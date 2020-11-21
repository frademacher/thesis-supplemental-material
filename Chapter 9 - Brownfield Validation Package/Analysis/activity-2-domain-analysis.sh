#!/usr/bin/env bash
# You need at least Java 11 in order to run the static analyzer's JAR
source export_java_home.sh
bash export_java_home.sh

RAW_RESULT_FILE="Produced Result Files/Raw Results.txt"

static_analysis() {
    serviceName=$1
    echo "" >> "$RAW_RESULT_FILE"
    printf '%.s~' {1..80} >> "$RAW_RESULT_FILE"
    printf "\nSAR Activity 2: Domain Model Information for Microservice $serviceName\n" >> "$RAW_RESULT_FILE"
    printf '%.s~' {1..80} >> "$RAW_RESULT_FILE"
    echo "" >> "$RAW_RESULT_FILE"

    domainModelPath=$2
    intermediateModelPath=$3
    csvFile=$(csv_file_name $serviceName)
    java -jar de.fhdo.lemma.analyzer-0.7.0-SNAPSHOT-standalone.jar \
        -s "../Reconstruction LEMMA Models/$domainModelPath" \
        -i "../Reconstruction LEMMA Models/intermediate/$intermediateModelPath" \
        --invoke_only_specified_phases intermediate_model_validation \
        --csv_file="$csvFile" \
        --csv_column_prefix="$serviceName" | tee -a "$RAW_RESULT_FILE"
}

csv_file_name() {
    serviceName=$1
    echo "Produced Result Files/activity-2-domain-analysis-$serviceName.csv"
}

to_tex_vars() {
    serviceName=$1
    texFile="Produced Result Files/brownfield-generated-vars-$serviceName.tex"
    csvFile=$(csv_file_name $serviceName)
    if [ -f "Produced Result Files/csv2tex_vars.py" ]; then
        python3 "Produced Result Files/csv2tex_vars.py" "$texFile" "$csvFile"
        $(cat "$texFile" >> "brownfield-generated-vars.tex")
    fi
}

mkdir -p "Produced Result Files"

static_analysis "customerCore" \
    "customer-core/customerCore.data" \
    "mapping models/customerCore/domain_customerCore.xmi"
to_tex_vars "customerCore"

static_analysis "customerManagementBackend" \
    "customer-management-backend/customerManagementBackend.data" \
    "mapping models/customerManagementBackend/customerManagementBackend_customerManagementBackend.xmi"
to_tex_vars "customerManagementBackend"

static_analysis "customerSelfServiceBackend" \
    "customer-self-service-backend/customerSelfServiceBackend.data" \
    "mapping models/customerSelfServiceBackend/customerSelfServiceBackend_customerSelfServiceBackend.xmi"
to_tex_vars "customerSelfServiceBackend"

static_analysis "policyManagementBackend" \
    "policy-management-backend/policyManagementBackend.data" \
    "mapping models/policyManagementBackend/policyManagementBackend_policyManagementBackend.xmi"
to_tex_vars "policyManagementBackend"