## Validation Package for the Evaluation of LEMMA's Capabilities in Microservice Architecture Reconstruction and Quality Attribute Assessment in Brownfield Microservice Architecture Engineering
This validation package enables to reproduce our results in evaluating [LEMMA](https://github.com/SeelabFhdo/lemma/) in brownfield Microservice Architecture (MSA) engineering scenarios. The package comprises the (i) source code of the reconstructed architecture [Lakeside Mutual](https://github.com/Microservice-API-Patterns/LakesideMutual) in [this version](https://github.com/Microservice-API-Patterns/LakesideMutual/tree/196716d47fa0d4bdcb0ca314d597e287ab67f074); (ii) reconstructed LEMMA models; (iii) standalone executable of [LEMMA's static analyzer](https://github.com/SeelabFhdo/lemma/tree/master/de.fhdo.lemma.analyzer) including [LEMMA's static analysis library](https://github.com/SeelabFhdo/lemma/tree/master/de.fhdo.lemma.analyzer.lib); (iv) scripts used to produce the raw and evaluation data from which we derived our evaluation results; and (v) produced raw data themselves.

The following Sections 1 to 3 describe the structure and contents of the validation package in more detail and also include the instructions for reproducing our results. To this end, the sections are ordered chronologically by the required reproduction steps.

### 1 Software Architecture Reconstruction
All raw data are extracted based on the reconstructed source code of Lakeside Mutual. It can be found in the `Reconstruction Source Code` folder of the validation package. The reconstructed LEMMA domain, service, mapping, operation, and technology models are contained in the `Reconstruction LEMMA Models` of the validation package. They can be examined, including syntax highlighting and validation, by means of a LEMMA-Enabled Eclipse installation, i.e., an Eclipse installation that comprises the Eclipse plugins of the [latest LEMMA release](https://github.com/SeelabFhdo/lemma/releases) in its `dropins` folder, for example.

### 2 Static Model Analysis and Metrics Measurement
The `Analysis` folder of the validation package contains all necessary scripts and executables to reproduce the measurements of the considered metrics. To reproduce our results, please follow these preliminary steps for code generation:
1. The `Produced Result Files` folder in the validation package should be renamed, after the validation package repository was cloned to hard disk. The folder comprises all raw data (cf. Step 2. being used to derive our evaluation results. It will automatically be re-created during static model analysis and metrics measurement.
3. LEMMA's static analyzer requires Java 11 or greater. If your Java version is below 11, you may use the `export_java_home.sh` `bash` script in the `Analysis` folder of the validation package to temporarily let your `JAVA_HOME` environment variable point to a Java executable equal or greater version 11 during static analysis.
4. The static analysis scripts require the following dependencies to be installed on the computer on which they are executed:
   - `bash` 4.4.20 or greater
   - [`cloc`](https://github.com/AlDanial/cloc) 1.84 or greater
   - `Java` 11 or greater (see above)
   - `Python` 3.6.9 or greater

After all preliminary requirements were met, the static model analyses and metrics measurements may be conducted. To this end, we provide the following `bash` scripts in the `Analysis` folder of the validation package:
1. `activity-1-loc-analysis.sh`: You may execute this script in a terminal to retrieve the LOC numbers of the reconstructed architecture Lakeside Mutual. Furthermore, the script will also print the LOC numbers of the reconstructed LEMMA models for convenience reasons.
2. `activity-2-domain-analysis.sh`: This script executes static analyses on the domain model of each reconstructed Lakeside Mutual microservice and prints the results. Result data comprise, e.g., the number of domain concepts or the distribution of features.
3. `activity-3-service-analysis.sh`: This script executes static analyses on the service model of each reconstructed Lakeside Mutual microservice and prints the results. Result data comprise, e.g., a general overview of a service model (number of microservices, interfaces, operations etc.) as well as all metrics, whose static computation LEMMA supports.

All script output is also appended to the `Raw Results.txt` file in the `Produced Result Files` sub-folder of the `Analysis` folder for additional examination.

### 3 Manual Execution of the Static Analyzer
The `analyzer-commands` file in the `Analysis` folder of the validation package states commands to manually execute LEMMA's static analyzer, e.g., to perform a basic analysis of a certain reconstructed domain model or retrieve results for a selected metrics set. The commands may therefore be used to manually reproduce our results, e.g., on a sample basis.