package bhavesh.dangi.masterdataservice.mapper;

import bhavesh.dangi.masterdataservice.entity.Airport;
import bhavesh.dangi.masterdataservice.dto.UpdateAirport;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AirportMapper {

    Airport map(bhavesh.dangi.masterdataservice.dto.Airport airport);

    bhavesh.dangi.masterdataservice.dto.Airport map(Airport airport);

    void map(UpdateAirport updateAirport, @MappingTarget Airport airport);
}
