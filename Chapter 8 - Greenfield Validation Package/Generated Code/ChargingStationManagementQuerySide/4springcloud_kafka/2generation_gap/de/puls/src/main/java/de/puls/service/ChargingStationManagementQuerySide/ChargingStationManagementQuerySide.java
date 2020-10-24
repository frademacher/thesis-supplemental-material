package de.puls.service.ChargingStationManagementQuerySide;

import de.fhdo.lemma.msa.services.LemmaMicroservice;
import de.fhdo.lemma.msa.services.LemmaMicroserviceType;
import de.puls.service.ChargingStationManagementQuerySide.gen.ChargingStationManagementQuerySideGenImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/* This class might comprise custom code. It will not be overwritten by the code generator as long as it
extends ChargingStationManagementQuerySideGenImpl. As soon as this is not the case anymore, this file will be 
overwritten, when the code generator is not explicitly invoked with the --preserve_existing_files 
command line option! */
@LemmaMicroservice(type = LemmaMicroserviceType.FUNCTIONAL)
@SpringBootApplication(scanBasePackages = "de.puls")
@EnableSwagger2()
public class ChargingStationManagementQuerySide extends ChargingStationManagementQuerySideGenImpl {

    public static void main(String[] args) {
        SpringApplication.run(ChargingStationManagementQuerySide.class, args);
    }
}
