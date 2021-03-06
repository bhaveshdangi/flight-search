package bhavesh.dangi.connectionbuilderservice.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FlightConnectionRequest {

    private String departureAirport;

    private String arrivalAirport;
}
