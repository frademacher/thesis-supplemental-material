## Validation Package for the Evaluation of LEMMA's Code Generation Efficiency in Greenfield Microservice Architecture Engineering
This validation package enables to reproduce our results in evaluating [LEMMA](https://github.com/SeelabFhdo/lemma/) in greenfield Microservice Architecture (MSA) engineering scenarios. The package comprises the (i) LEMMA models for the logical Charging Station Management Microservice of the Park and Charge Platform; (ii) [Java Base Generator and employed Genlets](https://github.com/SeelabFhdo/lemma/tree/master/code%20generators) as executable Java archives; (iii) scripts used to produce the raw and evaluation data from which we derived our evaluation results; and (iv) produced raw data themselves.

The following Sections 1 to 3 describe the structure and contents of the validation package in more detail and also include the instructions for reproducing our results. To this end, the sections are ordered chronologically by the required reproduction steps. Section 4 describes the derived raw data, which are also part of the validation package to ensure reproducibility even without having to execute each of the reproduction steps in Sections 1 to 3.

### 1 Code Generation
All raw data are extracted based on the code being generated from the LEMMA models for the logical Charging Station Management Microservice. The source domain, service, mapping, and technology models may be found in the `Source LEMMA Models` folder of the validation package. They can be examined, including syntax highlighting and validation, by means of a LEMMA-Enabled Eclipse installation, i.e., an Eclipse installation that comprises the Eclipse plugins of the [latest LEMMA release](https://github.com/SeelabFhdo/lemma/releases) in its `dropins` folder, for example.

For the actual code generation, the intermediate representations of the models are used. They can be found in the `Intermediate LEMMA Models` folder of the validation package or be derived from the source models using LEMMA's Eclipse plugins.

Preliminary steps for code generation:
1. Prior to executing the code generation, the `Generated Code` folder in the validation package should be renamed, after the validation package repository was cloned to hard disk. The folder comprises the generated code and additional raw data (cf. Step 2) being used to derive our evaluation results. It will automatically be re-created by the Java Base Generator when the code generation is executed from the cloned validation package.
2. The code generation script requires Java 12 or greater. If your Java version is below 12, you may use the `export_java_home.sh` `bash` script in the `Generators` folder of the validation package to temporarily let your `JAVA_HOME` environment variable point to a Java executable equal or greater version 12 during code generation execution.
3. The code generation script requires the following dependencies to be installed on the computer on which it is executed:
   - `bash` 4.4.20 or greater
   - `Java` 12 or greater (see above)
   - [`Maven`](https://maven.apache.org/) 3.6.0 or greater. The `mvn` executable must further be contained in the `PATH` variable (which by default should be the case).

After all preliminary requirements were met, the actual generation of the code for the logical Charging Station Management Microservice may be triggered by executing the `generate.sh` `bash` script in the `Generators` folder of the validation package from a terminal console.

The script iteratively instruments the Java Base Generator to produce code for the command and query side microservices of the Charging Station Management Microservice. Therefore, code will be generated for each side first without any Genlets and then by incrementing the applied Genlets for each subsequent code generator execution from Spring, over Domain Events (does not generate any additional code at all) and Kafka, to DDD. For a given Genlet or when the code generator is executed without any Genlet, each code generation pattern will be applied iteratively going from Extended Generation Gap over Generation Gap to plain generation. Consequently, the set of generated codebases is the cartesian product
```
(CommandSide, QuerySide) x                                  // Set of side microservices
  (No Genlet, + Spring, + Domain Events, + Kafka, + DDD) x  // Set of Genlets
    (Extended Generation Gap, Generation Gap, Plain)        // Set of code generation patterns
```

After generation of a certain codebase from the combination of a side microservice with a (or no) Genlet and a code generation pattern, the codebase is compiled leveraging `Maven` and the generated `pom.xml` for that codebase. The code generation script informs about its progress by printing messages about each generation and compilation step to standard output.

After the script executed successfully, generated codebases may be found in the sub-folders of the `Generated Code` folder in the cloned validation package in the form of a folder hierarchy consisting of the folder for the side microservice, applied Genlet, and code generation pattern. The Genlet and code generation pattern folders are prefixed by an index that identifies their execution order. For example, the relative path `Generated Code/ChargingStationManagementQuerySide/5ddd/2generation_gap` points to the codebase for the query side microservice derived from employing the Spring, Domain Events, Kafka, and DDD Genlets together with the Generation Gap pattern.

The executable Java archive for the Java Base Generator is clustered in the `Generators/java_base-0.7.0-SNAPSHOT-standalone.jar` file in the validation package. The executable Genlet archives may be found in the `Generators/genlets` folder.

### 2 LOC Counting
To determine the LOC numbers from the generated code, the `loc.sh` `bash` script from the `Analysis` folder may be executed. It requires the following dependencies to be installed on the computer on which it is executed:
- `bash` 4.4.20 or greater
- [`cloc`](https://github.com/AlDanial/cloc) 1.84 or greater
- [`jq`](https://stedolan.github.io/jq/) 1.5.1 or greater

The script will produce two CSV files in the root folder of each generated codebase. The `loc_analysis.csv` file comprises the numbers of files and LOC for the current codebase per language (the `LEMMA_domain` language identifies the files and LOC of LEMMA domain and mapping models). The `loc_analysis_domain_only.csv` file clusters numbers of the files and LOC for the domain code generation scope only. The files and LOC of the LEMMA models and generated Avro specification files (files with extension `.asvc` in the `Generated Code` folder of the validation package) are added to the CSV files once for each generated codebase. (Like the intermediate LEMMA models, the Avro specification files may also be derived leveraging LEMMA's Eclipse plugins.)

### 3 Analysis
To reproduce our evaluation results per evaluation step from the extracted raw LOC CSV files, the `analyze.py` Python script in the `Analysis` folder of the validation package may be used. It requires the following dependencies to be installed on the computer on which it is executed:
- [`Python`](https://www.python.org/) 3.6.9 or greater.

When executing the script from the terminal console, it will print the evaluation results for each side microservice and evaluation step. The script also prints the assumed baseline, i.e., the combination of Genlet and code generation pattern, from which the evaluation results were derived for the respective side microservice and evaluation step.

### 4 Raw Data Contained in the Validation Package
The validation also comprises raw data for each of the reproduction steps described in Sections 1 to 3. In case one or more reproduction steps could not be executed, the reproduction of our results is still feasible by means of the provided raw data. For the reproduction steps, the raw may be found in the following locations inside the validation package:
1. Code Generation: The `Generated Code` folder comprises the generated microservice code produced by the Java Base Generator for each possible codebase based on Genlets and code generation pattern combinations.
2. LOC Counting: The `Generated Code` folder comprises the LOC CSV files for each generated codebase as produced by the `loc.sh` script.
3. Analysis: The `Analysis/Raw Results.txt` file comprises the output of the `analyze.py` Python script as it was executed on the computer of the author.