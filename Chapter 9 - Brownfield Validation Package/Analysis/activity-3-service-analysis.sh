#!/usr/bin/env bash
# You need at least Java 11 in order to run the static analyzer's JAR
source export_java_home.sh
bash export_java_home.sh

RAW_RESULT_FILE="Produced Result Files/Raw Results.txt"

static_analysis() {
    serviceName=$1
    echo "" >> "$RAW_RESULT_FILE"
    printf '%.s~' {1..80} >> "$RAW_RESULT_FILE"
    printf "\nSAR Activity 3: Service Model Information for Microservice $serviceName\n" >> "$RAW_RESULT_FILE"
    printf '%.s~' {1..80} >> "$RAW_RESULT_FILE"
    echo "" >> "$RAW_RESULT_FILE"

    serviceModelPath=$2
    intermediateModelPath=$3
    csvFile=$(csv_file_name $serviceName)
    java -jar de.fhdo.lemma.analyzer-0.7.0-SNAPSHOT-standalone.jar \
        -s "../Reconstruction LEMMA Models/$serviceModelPath" \
        -i "../Reconstruction LEMMA Models/intermediate/$intermediateModelPath" \
        --invoke_only_specified_phases intermediate_model_validation \
        --csv_file="$csvFile" \
        --csv_column_prefix="$serviceName" \
        --analysis_modules="basic-service-analysis" \
        --analysis_modules="service-metrics-athanasopoulos" \
        --analysis_modules="service-metrics-engel" \
        --analysis_modules="service-metrics-haupt" \
        --analysis_modules="service-metrics-hirzalla" \
        --service-metrics-athanasopoulos-verbose \
        --service-metrics-engel-verbose \
        --service-metrics-hirzalla-verbose | tee -a "$RAW_RESULT_FILE"
}

csv_file_name() {
    serviceName=$1
    echo "Produced Result Files/activity-3-service-analysis-$serviceName.csv"
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

static_analysis "customerCore" \
    "customer-core/customerCore.services" \
    "mapping models/customerCore.xmi"
to_tex_vars "customerCore"

static_analysis "customerManagementBackend" \
    "customer-management-backend/customerManagementBackend.services" \
    "mapping models/customerManagementBackend.xmi"
to_tex_vars "customerManagementBackend"

static_analysis "customerSelfServiceBackend" \
    "customer-self-service-backend/customerSelfServiceBackend.services" \
    "mapping models/customerSelfServiceBackend.xmi"
to_tex_vars "customerSelfServiceBackend"

static_analysis "policyManagementBackend" \
    "policy-management-backend/policyManagementBackend.services" \
    "mapping models/policyManagementBackend.xmi"
to_tex_vars "policyManagementBackend"