package de.puls.service.ChargingStationManagementQuerySide.interfaces;

import de.puls.domain.ChargingStationManagement.Location;
import de.puls.domain.ChargingStationManagement.ParkingAreaInformation;
import de.puls.domain.ChargingStationManagement.ParkingAreaInformationList;
import de.puls.service.ChargingStationManagementQuerySide.interfaces.gen.QuerySideGenImpl;
import de.puls.service.ChargingStationManagementQuerySide.interfaces.operations.QuerySide.getParkingArea.ParkingAreaNotFoundException;
import de.puls.service.ChargingStationManagementQuerySide.interfaces.operations.QuerySide.getParkingAreas.NoParkingAreasFoundException;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/* This class might comprise custom code. It will not be overwritten by the code generator as long as it
extends QuerySideGenImpl. As soon as this is not the case anymore, this file will be 
overwritten, when the code generator is not explicitly invoked with the --preserve_existing_files 
command line option! */
@Component()
@RestController()
public class QuerySide extends QuerySideGenImpl {

    @Override
    public ResponseEntity<ParkingAreaInformation> getParkingArea(@PathVariable() Long id) throws ParkingAreaNotFoundException {
        checkRequiredParametersOfGetParkingArea(id);
        // TODO Implement this. Might otherwise throw UnsupportedOperationException from delegating call.
        return super.getParkingArea(id);
    }

    @Override
    public ResponseEntity<ParkingAreaInformationList> getParkingAreas(@RequestBody() @Valid() Location northEastBound, @RequestBody() @Valid() Location southWestBound) throws NoParkingAreasFoundException {
        checkRequiredParametersOfGetParkingAreas(northEastBound, southWestBound);
        // TODO Implement this. Might otherwise throw UnsupportedOperationException from delegating call.
        return super.getParkingAreas(northEastBound, southWestBound);
    }
}
