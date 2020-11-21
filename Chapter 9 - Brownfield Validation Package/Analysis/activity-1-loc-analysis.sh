#!/usr/bin/env bash

execute_cloc_excl() {
    exclusionFile=$1
    cloc ../Reconstruction\ Source\ Code/LakesideMutual \
        --exclude-list-file="$exclusionFile" \
        --read-lang-def=cloc_properties_def \
        --exclude-ext=svg
}

execute_cloc() {
    execute_cloc_excl "loc_excluded_files"
}

execute_lemma_cloc() {
    langDefFile=$1
    cloc ../Reconstruction\ LEMMA\ Models \
        --force-lang-def="$langDefFile"
}

to_tex_var() {
    name=$1
    value=$2
    suffix=$3
    echo "\def \brownEval$name$suffix{$value}" >> brownfield-generated-vars.tex
}

extract_loc_info() {
    clocOutput=$1
    language=$2
    echo $(echo "$clocOutput" | grep $language | awk '{ print $2, $4, $5 }')
}

to_tex_vars() {
    clocOutput=$1
    language=$2
    suffix=$3
    locInfo=$(extract_loc_info "$clocOutput" "$language")
    texVars=( $locInfo )
    to_tex_var "FileCount$language" ${texVars[0]} $suffix
    to_tex_var "CommentLoc$language" ${texVars[1]} $suffix
    to_tex_var "CodeLoc$language" ${texVars[2]} $suffix
}

mkdir -p "Produced Result Files"

printf '\e[35m%.s~\e[m' {1..80}
printf "\n\e[35mSAR Activity 1: Line Counts (Lakeside Mutual Complete)\e[m\n"
printf '\e[35m%.s~\e[m' {1..80}
echo ""

RAW_RESULT_FILE="Produced Result Files/Raw Results.txt"
printf '%.s~' {1..80} >> "$RAW_RESULT_FILE"
printf "\nSAR Activity 1: Line Counts (Lakeside Mutual complete)\n" >> "$RAW_RESULT_FILE"
printf '%.s~' {1..80} >> "$RAW_RESULT_FILE"
echo "" >> "$RAW_RESULT_FILE"
execute_cloc | tee -a "$RAW_RESULT_FILE"

clocOutput=$(execute_cloc)
to_tex_vars "$clocOutput" "SUM"
to_tex_vars "$clocOutput" "Java"

echo ""
printf '\e[35m%.s~\e[m' {1..80}
printf "\n\e[35mSAR Activity 1: Line Counts (Lakeside Mutual top-level elements)\e[m\n"
printf '\e[35m%.s~\e[m' {1..80}
echo ""

echo "" >> "$RAW_RESULT_FILE"
printf '%.s~' {1..80} >> "$RAW_RESULT_FILE"
printf "\nSAR Activity 1: Line Counts (Lakeside Mutual top-level elements)\n" >> "$RAW_RESULT_FILE"
printf '%.s~' {1..80} >> "$RAW_RESULT_FILE"
echo "" >> "$RAW_RESULT_FILE"
execute_cloc_excl "loc_excluded_toplevel_folders" | tee -a "$RAW_RESULT_FILE"

clocOutputTopLevel=$(execute_cloc_excl "loc_excluded_toplevel_folders")
to_tex_vars "$clocOutputTopLevel" "SUM" "TopLevel"

echo ""
printf '\e[35m%.s~\e[m' {1..80}
printf "\n\e[35mSAR Activity 1: Line Counts (LEMMA complete)\e[m\n"
printf '\e[35m%.s~\e[m' {1..80}
echo ""

echo "" >> "$RAW_RESULT_FILE"
printf '%.s~' {1..80} >> "$RAW_RESULT_FILE"
printf "\nSAR Activity 1: Line Counts (LEMMA complete)\n" >> "$RAW_RESULT_FILE"
printf '%.s~' {1..80} >> "$RAW_RESULT_FILE"
echo "" >> "$RAW_RESULT_FILE"
execute_lemma_cloc "cloc_lemma_def" | tee -a "$RAW_RESULT_FILE"

clocOutputLemmaComplete=$(execute_lemma_cloc "cloc_lemma_def")
to_tex_vars "$clocOutputLemmaComplete" "SUM" "Lemma"

echo ""
printf '\e[35m%.s~\e[m' {1..80}
printf "\n\e[35mSAR Activity 1: Line Counts (LEMMA technology)\e[m\n"
printf '\e[35m%.s~\e[m' {1..80}
echo ""

echo "" >> "$RAW_RESULT_FILE"
printf '%.s~' {1..80} >> "$RAW_RESULT_FILE"
printf "\nSAR Activity 1: Line Counts (LEMMA technology)\n" >> "$RAW_RESULT_FILE"
printf '%.s~' {1..80} >> "$RAW_RESULT_FILE"
echo "" >> "$RAW_RESULT_FILE"
execute_lemma_cloc "cloc_technology_def" | tee -a "$RAW_RESULT_FILE"

clocOutputLemmaTechnology=$(execute_lemma_cloc "cloc_technology_def")
to_tex_vars "$clocOutputLemmaTechnology" "SUM" "LemmaTechnology"