package de.puls.service.ChargingStationManagementQuerySide;

import de.fhdo.lemma.msa.services.LemmaMicroservice;
import de.fhdo.lemma.msa.services.LemmaMicroserviceType;
import de.puls.service.ChargingStationManagementQuerySide.gen.ChargingStationManagementQuerySideGen;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@LemmaMicroservice(type = LemmaMicroserviceType.FUNCTIONAL)
@SpringBootApplication(scanBasePackages = "de.puls")
@EnableSwagger2()
public class ChargingStationManagementQuerySide implements ChargingStationManagementQuerySideGen {

    public static void main(String[] args) {
        SpringApplication.run(ChargingStationManagementQuerySide.class, args);
    }
}
