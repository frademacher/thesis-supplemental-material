package de.puls.service.ChargingStationManagementQuerySide.interfaces.gen;

import de.puls.domain.ChargingStationManagement.Location;
import de.puls.domain.ChargingStationManagement.ParkingAreaInformation;
import de.puls.domain.ChargingStationManagement.ParkingAreaInformationList;
import de.puls.service.ChargingStationManagementQuerySide.interfaces.operations.QuerySide.getParkingArea.ParkingAreaNotFoundException;
import de.puls.service.ChargingStationManagementQuerySide.interfaces.operations.QuerySide.getParkingAreas.NoParkingAreasFoundException;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = {"/resources/v1"})
public abstract class QuerySideGenImpl implements QuerySideGen {

    @ApiOperation(value = "API endpoint for retrieving information about a single parking area")
    @GetMapping(value = "/parkingarea/id/{id}")
    @Override
    public ResponseEntity<ParkingAreaInformation> getParkingArea(@ApiParam(value = "Identifier of the parking area", required = true) @PathVariable() Long id) throws ParkingAreaNotFoundException {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    protected void checkRequiredParametersOfGetParkingArea(Long id) {
        if (id == null)
            throw new IllegalArgumentException("Required parameter \"id\" must not be null");
    }

    @ApiOperation(value = "API endpoint for retrieving all parking areas in a given geographic area")
    @GetMapping(value = "/parkingarea/geo")
    @Override
    public ResponseEntity<ParkingAreaInformationList> getParkingAreas(@ApiParam(value = "Coordinates for north-east area bound", required = true) @RequestBody() @Valid() Location northEastBound, @ApiParam(value = "Coordinates for south-west area bound", required = true) @RequestBody() @Valid() Location southWestBound) throws NoParkingAreasFoundException {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    protected void checkRequiredParametersOfGetParkingAreas(Location northEastBound, Location southWestBound) {
        if (northEastBound == null)
            throw new IllegalArgumentException("Required parameter \"northEastBound\" must not be null");
        if (southWestBound == null)
            throw new IllegalArgumentException("Required parameter \"southWestBound\" must not be null");
    }
}
