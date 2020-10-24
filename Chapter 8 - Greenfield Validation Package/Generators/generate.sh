#!/usr/bin/env bash

services=(
    ChargingStationManagementCommandSide
    ChargingStationManagementQuerySide
)

genlets=(
    "de.fhdo.lemma.model_processing.code_generation.springcloud-0.7.0-SNAPSHOT.jar"
    "de.fhdo.lemma.model_processing.code_generation.springcloud.domain_events-0.7.0-SNAPSHOT.jar"
    "de.fhdo.lemma.model_processing.code_generation.springcloud.kafka-0.7.0-SNAPSHOT.jar"
    "de.fhdo.lemma.model_processing.code_generation.ddd-0.7.0-SNAPSHOT.jar"
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

prepare_generation() {
    source export_java_home.sh
    bash export_java_home.sh

    mvn install:install-file \
        -Dfile=libs/de.fhdo.lemma.msa-0.0.1-SNAPSHOT.jar \
        -DgroupId=de.fhdo.lemma.msa \
        -DartifactId=de.fhdo.lemma.msa \
        -Dversion=0.0.1-SNAPSHOT \
        -Dpackaging=jar
}

generate() {
    service=$1
    pattern=$2
    lastGenletIndex=$3
    targetFolder=$4

    genletsAsCliOptions=""
    if [ $lastGenletIndex -gt -1 ]
    then
        for i in "${!genlets[@]}"; do
            genletsAsCliOptions+="--genlet=genlets/${genlets[i]} "
            if [ $i == $lastGenletIndex ]
            then
                break
            fi
        done
    fi

    asm="../Intermediate LEMMA Models/service models/$service.xmi"

    targetPath="../Generated Code/$targetFolder"
    echo -e "\e[94m[GENERATION]\e[0m Generating code for service" \
        "\e[35m$service\e[0m to \e[35m$targetPath\e[0m with pattern" \
        "\e[35m$pattern\e[0m"
    java -jar java_base-0.7.0-SNAPSHOT-standalone.jar \
        -s "../Source LEMMA Models/$service.mapping" \
        -i "../Intermediate LEMMA Models/mapping models/$service.xmi" \
        -t "$targetPath" \
        code_generation main --code_generation_serializer=$pattern \
        --alternative_intermediate_service_model="$asm" \
        $genletsAsCliOptions

    if [ $? -eq 0 ]
    then
        echo -e "\e[94m[GENERATION]\e[0m DONE"
    else
        exit 1
    fi
}

compile() {
    targetFolder=$1
    targetPath="../Generated Code/$targetFolder"
    relativePomPath=$(find "$targetPath" -name "pom.xml")
    echo -e "\e[94m[COMPILATION]\e[0m Compiling service code located in"\
        "\e[35m$targetPath\e[0m"

    mvn -f "$relativePomPath" clean package > /dev/null

    if [ $? -eq 0 ]
    then
        echo -e "\e[94m[COMPILATION]\e[0m DONE"
    else
        exit 1
    fi
}

folder_for_genlet() {
    genletIndex=$1
    if [ $genletIndex -gt -1 ]
    then
        echo ${genletFolders[genletIndex]}
    else
        echo "none"
    fi
}

folder_for_pattern() {
    echo $1 | tr '-' '_'
}

delim() {
    echo -e "\e[94m"
    printf -- '-%.0s' {1..100}; echo ""
    echo -e "\e[0m"
}

prepare_generation

for s in "${!services[@]}"; do
    service=${services[s]}
    lastGenletIndex=$(( ${#genlets[@]} - 1 ))
    for g in `seq -1 $lastGenletIndex`;
    do
        folderForGenlet=$(folder_for_genlet $g)

        for p in "${!patterns[@]}"; do
            pattern=${patterns[p]}
            folderForPattern=$(folder_for_pattern $pattern)

            normalizedGenletIndex=$(( $g + 2 ))
            normalizedPatternIndex=$(( $p + 1 ))
            targetFolder="$service/$normalizedGenletIndex$folderForGenlet/\
$normalizedPatternIndex$folderForPattern"
            generate $service $pattern $g $targetFolder
            echo ""
            compile $targetFolder
            delim
        done
    done
done