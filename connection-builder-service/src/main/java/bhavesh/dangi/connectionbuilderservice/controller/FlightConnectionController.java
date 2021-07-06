package bhavesh.dangi.connectionbuilderservice.controller;

import bhavesh.dangi.connectionbuilderservice.dto.ConnectedFlight;
import bhavesh.dangi.connectionbuilderservice.dto.FlightConnectionRequest;
import bhavesh.dangi.connectionbuilderservice.service.FlightConnectionService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class FlightConnectionController {

    private final FlightConnectionService fliFlightConnectionService;

    public FlightConnectionController(FlightConnectionService fliFlightConnectionService) {
        this.fliFlightConnectionService = fliFlightConnectionService;
    }

    @PostMapping("/flight-connections")
    public List<ConnectedFlight> getFlightConnections(@RequestBody FlightConnectionRequest request) {

        return fliFlightConnectionService.getConnectedFlights(request);
    }
}
