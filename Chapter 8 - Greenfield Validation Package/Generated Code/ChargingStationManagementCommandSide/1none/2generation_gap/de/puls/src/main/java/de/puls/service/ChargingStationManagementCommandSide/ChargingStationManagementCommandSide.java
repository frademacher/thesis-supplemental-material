package de.puls.service.ChargingStationManagementCommandSide;

import de.fhdo.lemma.msa.services.LemmaMicroservice;
import de.fhdo.lemma.msa.services.LemmaMicroserviceType;
import de.puls.service.ChargingStationManagementCommandSide.gen.ChargingStationManagementCommandSideGenImpl;

/* This class might comprise custom code. It will not be overwritten by the code generator as long as it
extends ChargingStationManagementCommandSideGenImpl. As soon as this is not the case anymore, this file will be 
overwritten, when the code generator is not explicitly invoked with the --preserve_existing_files 
command line option! */
@LemmaMicroservice(type = LemmaMicroserviceType.FUNCTIONAL)
public class ChargingStationManagementCommandSide extends ChargingStationManagementCommandSideGenImpl {

    public ChargingStationManagementCommandSide() {
    }
}
