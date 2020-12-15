## Validation Package for the Evaluation of LEMMA's Impact on the Efficiency of Greenfield Microservice Development with Code Generation
This validation package enables to reproduce our results in evaluating [LEMMA](https://github.com/SeelabFhdo/lemma/) in greenfield Microservice Architecture (MSA) engineering scenarios. The package comprises the (i) LEMMA models for the logical Charging Station Management Microservice of the Park and Charge Software Platform; (ii) [Java Base Generator and employed Genlets](https://github.com/SeelabFhdo/lemma/tree/master/code%20generators) as executable Java archives; (iii) scripts used to produce the raw and evaluation data from which we derived our evaluation results; and (iv) produced raw data themselves.

The following Sections 1 to 3 describe the structure and contents of the validation package in more detail and also include the instructions for reproducing our results. To this end, the sections are ordered chronologically by the required reproduction steps. Section 4 describes the derived raw data, which are also part of the validation package to ensure reproducibility even without having to execute each of the reproduction steps in Sections 1 to 3.

### 1 Code Generation
All raw data originate from the code, which is generated from the LEMMA models for the logical Charging Station Management Microservice. The domain, service, mapping, and technology models may be found in the `Source LEMMA Models` folder of the validation package. They are examinable, including syntax highlighting and validation, by means of a LEMMA-enabled Eclipse installation, e.g., an Eclipse installation that comprises the Eclipse plugins of the [latest LEMMA release](https://github.com/SeelabFhdo/lemma/releases) in its `dropins` folder.

For the actual code generation, we leveraged the intermediate representations of the LEMMA models. They can be found in the `Intermediate LEMMA Models` folder of the validation package, but are also derivable from the provided source models using LEMMA's Eclipse plugins.

Preliminary steps for code generation:
1. After the validation package repository was cloned to hard disk and prior to executing the code generation, the `Generated Code` folder in the validation package should be renamed. The folder comprises the generated code and additional raw data (cf. Step 2), which we used to derive our evaluation results. The folder and its contents will however automatically be re-created by the Java Base Generator when the code generation is executed from the cloned validation package.
2. The code generation script requires Java 12 or greater. To overwrite a possible default Java version below 12, we include the `export_java_home.sh` `bash` script in the `Generators` folder of the validation package. It can temporarily set a `JAVA_HOME` environment variable to point to a Java executable equal or greater version 12 during code generation.
3. The code generation script requires the following dependencies to be installed on the executing computer:
   - `bash` 4.4.20 or greater
   - `Java` 12 or greater (see above)
   - [`Maven`](https://maven.apache.org/) 3.6.0 or greater. The `mvn` executable must further be contained in the `PATH` environment variable (which should be the usual case).

After all preliminary requirements were met, the actual generation of the code for the logical Charging Station Management Microservice may be triggered by executing the `generate.sh` `bash` script in the `Generators` folder of the validation package from a terminal console.

The script iteratively instruments the Java Base Generator to produce code for the command and query side microservices of the Charging Station Management Microservice. Therefore, code will be generated for each side first without any Genlets, and then by incrementing the applied Genlets for each subsequent code generator execution from Spring, over Domain Events (does not generate any additional code at all) and Kafka, to DDD. Each side-specific execution iteratively applies no code generation pattern(plain generation), the Generation Gap pattern, and the Extended Generation Gap pattern. Consequently, the set of generated codebases is the cartesian product
```
(CommandSide, QuerySide) x                                  // Set of side microservices
  (No Genlet, + Spring, + Domain Events, + Kafka, + DDD) x  // Set of Genlets
    (Extended Generation Gap, Generation Gap, Plain)        // Set of code generation patterns
```

The completion of the generation of a certain codebase follows its compilation by means of `Maven` and the codebase's generated `pom.xml`. The code generation script informs about its progress by printing messages about each generation and compilation step to standard output.

After the script executed successfully, generated codebases may be found in the sub-folders of the `Generated Code` folder. The sub-folders introduce a folder hierarchy consisting of the folder for the respective side microservice, applied Genlet, and code generation pattern. The Genlet and code generation pattern folders are prefixed by an index that identifies their execution order. For example, the relative path `Generated Code/ChargingStationManagementQuerySide/5ddd/2generation_gap` points to the codebase for the query side microservice derived from employing the Spring, Domain Events, Kafka, and DDD Genlets together with the Generation Gap pattern.

The executable Java archive for the Java Base Generator is clustered in the `Generators/java_base-0.7.0-SNAPSHOT-standalone.jar` file in the validation package. The executable Genlet archives may be found in the `Generators/genlets` folder.

### 2 LOC Counting
To determine the LOC numbers from the generated code, the `loc.sh` `bash` script from the `Analysis` folder can be used. It requires the following dependencies to be installed on the executing computer:
- `bash` 4.4.20 or greater
- [`cloc`](https://github.com/AlDanial/cloc) 1.84 or greater
- [`jq`](https://stedolan.github.io/jq/) 1.5.1 or greater

The script will produce two CSV files in the root folder of each generated codebase. The `loc_analysis.csv` file comprises the numbers of files and LOC for the current codebase per language (the `LEMMA_domain` language identifies the files and LOC of LEMMA domain and mapping models). The `loc_analysis_domain_only.csv` file clusters numbers of the files and LOC of only the Domain Viewpoint. The files and LOC of the LEMMA models and generated Avro schema declaration files (files with extension `.asvc` in the `Generated Code` folder of the validation package) are added to the CSV files once for each generated codebase. (Like the intermediate LEMMA models, the Avro files may also be derived leveraging LEMMA's Eclipse plugins.)

### 3 Analysis
To reproduce our evaluation results per evaluation step from the extracted raw LOC CSV files, the `analyze.py` Python script in the `Analysis` folder of the validation package may be used. It requires the following dependencies to be installed on the executing computer:
- [`Python`](https://www.python.org/) 3.6.9 or greater.

When executing the script from the terminal console, it will print the evaluation results for each side microservice and evaluation step. The script also prints the assumed baseline, i.e., the combination of Genlet and code generation pattern, from which the evaluation results were derived for the respective side microservice and evaluation step.

### 4 Raw Data Contained in the Validation Package
The validation package also comprises raw data for each of the reproduction steps described in Sections 1 to 3. In case one or more reproduction steps could not be executed, the reproduction of our results is still feasible by means of the provided raw data. For the aforementioned reproduction steps, the raw data may be found in the following locations within the validation package:
1. Code Generation: The `Generated Code` folder comprises the generated microservice code produced by the Java Base Generator for each possible codebase based on Genlets and code generation pattern combinations.
2. LOC Counting: The `Generated Code` folder comprises the LOC CSV files for each generated codebase as produced by the `loc.sh` script.
3. Analysis: The `Analysis/Raw Results.txt` file comprises the output of the `analyze.py` Python script as it was executed on the computer of the author.