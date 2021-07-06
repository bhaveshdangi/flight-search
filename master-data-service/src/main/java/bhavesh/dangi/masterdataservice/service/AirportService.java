package bhavesh.dangi.masterdataservice.service;

import bhavesh.dangi.masterdataservice.entity.Airport;
import bhavesh.dangi.masterdataservice.dto.UpdateAirport;
import bhavesh.dangi.masterdataservice.exception.ObjectAlreadyExistsException;
import bhavesh.dangi.masterdataservice.mapper.AirportMapper;
import bhavesh.dangi.masterdataservice.repository.AirportRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AirportService {

    private final AirportRepository airportRepository;

    private final AirportMapper airportMapper;

    public AirportService(AirportRepository airportRepository, AirportMapper airportMapper) {
        this.airportRepository = airportRepository;
        this.airportMapper = airportMapper;
    }

    public void create(bhavesh.dangi.masterdataservice.dto.Airport airport) {

        Airport airportEntity = airportMapper.map(airport);

        try {
            airportRepository.save(airportEntity);

        } catch (DataIntegrityViolationException e) {

            throw new ObjectAlreadyExistsException("Airport with code " + airport.getCode() + " is already exists.");
        }
    }

    public bhavesh.dangi.masterdataservice.dto.Airport find(String code) {

        Airport airport = airportRepository.findByCode(code);

        return airportMapper.map(airport);

    }

    public void update(String code, UpdateAirport updateAirport) {

        Airport airport = airportRepository.findByCode(code);

        airportMapper.map(updateAirport, airport);

        airportRepository.save(airport);

    }

    public void delete(String code) {

        Airport airport = airportRepository.findByCode(code);

        airportRepository.delete(airport);

    }

    public List<String> searchCodes(String code) {

        return airportRepository.findAirportCodes(code.toUpperCase());
    }
}
