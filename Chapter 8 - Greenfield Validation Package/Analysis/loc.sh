#!/usr/bin/env bash

services=(
    ChargingStationManagementCommandSide
    ChargingStationManagementQuerySide
)

genletFolders=(
    "springcloud"
    "domain_events"
    "springcloud_kafka"
    "ddd"
)

patterns=(
    "extended-generation-gap"
    "generation-gap"
    "plain"
)

cloc_source_models() {
    service=$1
    clocJson=$(cloc --force-lang-def=cloc_lemma_def \
        --exclude_ext=technology,iml \
        --exclude_dir=target,.idea \
        --match-f="(.*\.data|$service\.(services|mapping))" \
        "../Source LEMMA Models/" --json)
    parse_cloc_json_output "$clocJson"
}

cloc_source_models_domain() {
    clocJson=$(cloc --force-lang-def=cloc_lemma_domain_def \
        --exclude_dir=target,.idea \
        --match-f="(.*\.data|$service\.mapping)" \
        "../Source LEMMA Models/" --json)
    parse_cloc_json_output "$clocJson"
}

parse_cloc_json_output() {
    jqTransformer=$(echo 'del(.header) | del(.SUM) | keys[] as $k |' \
        '"\($k) \(.[$k].nFiles) \(.[$k].code);"')
    echo $(jq -r "$jqTransformer" <<< "$1")
}

cloc_avro_schemas() {
    clocJson=$(cloc --include-ext=avsc,avpr --force-lang-def=cloc_avro_def \
        --exclude_dir=target,.idea \
        --exclude_ext=csv,iml \
        "../Generated Code/" --json)
    parse_cloc_json_output "$clocJson"
}

cloc_generated_code() {
    targetFolder=$1
    directoryRegex=$2
    targetPath="../Generated Code/$targetFolder"
    if [[ $directoryRegex ]]
    then
        clocJson=$(cloc --match-d="$directoryRegex" \
            --exclude_dir=target,.idea \
            --read-lang-def=cloc_maven_def \
            --read-lang-def=cloc_properties_def \
            --exclude_ext=avsc,avpr,csv,data,iml,operation,services,technology \
            "$targetPath" --json)
    else
        clocJson=$(cloc --read-lang-def=cloc_maven_def \
            --exclude_dir=target,.idea \
            --read-lang-def=cloc_properties_def \
            --exclude_ext=avsc,avpr,csv,data,iml,operation,services,technology \
            "$targetPath" --json)
    fi
    parse_cloc_json_output "$clocJson"
}

folder_for_pattern() {
    echo $1 | tr '-' '_'
}

delim() {
    echo -e "\e[94m"
    printf -- '-%.0s' {1..100}; echo ""
    echo -e "\e[0m"
}

to_csv_rows() {
    isManual=$2
    if [[ $isManual = true ]]
    then
        manFlag="man"
    else
        manFlag="gen"
    fi

    isDomain=$3
    if [[ $isDomain = true ]]
    then
        domainFlag="domain"
    else
        domainFlag="noDomain"
    fi

    csv=$(echo "$1" | sed 's/; /\n/g' | sed "s/;//g" | sed 's/ /;/g')
    if [[ -z $csv ]]
    then
        echo ""
    else
        echo "$csv" | sed "s/$/;$manFlag;$domainFlag/g"
    fi
}

to_loc_file() {
    targetFolder="$1"
    avroCsv="$2"
    sourceModelCsv="$3"
    sourceModelsDomainCsv="$4"
    domainOnly=$5

    if [ $domainOnly = true ]
    then
        targetFile="$targetFolder/loc_analysis_domain_only.csv"
        generatedCsv=$(
            to_csv_rows "$(cloc_generated_code $targetFolder 'domain')" false \
                true
        )
    else
        targetFile="$targetFolder/loc_analysis.csv"
        generatedCsv=$(
            to_csv_rows "$(cloc_generated_code $targetFolder)" false false
        )
    fi

    if [[ $? -eq 0 ]]
    then
        echo -e "\e[94m[LOC]\e[0m Writing LOC information to "\
        "\e[35m$targetFile\e[0m"
    else
        exit 1
    fi

    if [[ ! -z "$generatedCsv" ]]
    then
        echo "$generatedCsv" > "../Generated Code/$targetFile"
    fi

    if [[ ! -z "$avroCsv" ]]
    then
        echo "$avroCsv" >> "../Generated Code/$targetFile"
    fi

    if [[ ! -z "$sourceModelCsv" ]]
    then
        echo "$sourceModelCsv" >> "../Generated Code/$targetFile"
    fi

    if [[ ! -z "$sourceModelsDomainCsv" ]]
    then
        echo "$sourceModelsDomainCsv" >> "../Generated Code/$targetFile"
    fi
}

avroCsv=$(to_csv_rows "$(cloc_avro_schemas)" false true)

for s in "${!services[@]}"; do
    service=${services[s]}
    sourceModelsCsv=$(to_csv_rows "$(cloc_source_models $service)" true false)
    sourceModelsDomainCsv=$(
        to_csv_rows "$(cloc_source_models_domain $service)" true true
    )
    #to_loc_file "$service" "$avroCsv" "$sourceModelsCsv" \
    #   "$sourceModelsDomainCsv"

    lastGenletFolderIndex=$(( ${#genletFolders[@]} - 1 ))
    for g in `seq -1 $lastGenletFolderIndex`;
    do
        normalizedGenletIndex=$(( $g + 2 ))

        if [[ $g -gt -1 ]]
        then
            folderForGenlet=${genletFolders[g]}
        else
            folderForGenlet="none"
        fi

        #targetFolder="$service/$normalizedGenletIndex$folderForGenlet"
        #to_loc_file "$targetFolder" "$avroCsv" "$sourceModelsCsv" \
        #   "$sourceModelsDomainCsv"

        for p in "${!patterns[@]}"; do
            normalizedPatternIndex=$(( $p + 1 ))

            pattern=${patterns[p]}
            folderForPattern=$(folder_for_pattern $pattern)
            targetFolder="$service/$normalizedGenletIndex$folderForGenlet/\
$normalizedPatternIndex$folderForPattern"
            to_loc_file "$targetFolder" "$avroCsv" "$sourceModelsCsv" \
                "$sourceModelsDomainCsv" false
            to_loc_file "$targetFolder" "$avroCsv" "$sourceModelsCsv" \
                "$sourceModelsDomainCsv" true
        done
    done
done