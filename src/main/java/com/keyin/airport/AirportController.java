package com.keyin.airport;

import com.keyin.action.ActionService;
import com.keyin.history.HistoryService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class AirportController {
    private final AirportService airportService;
    private final HistoryService historyService;
    private final ActionService actionService;

    public AirportController(AirportService airportService, HistoryService historyService, ActionService actionService) {
        this.airportService = airportService;
        this.historyService = historyService;
        this.actionService = actionService;
    }

    @GetMapping("/airport")
    public List<Airport> getAllAirport() {
        historyService.addToHistory("getAllAirport()", "/airport", LocalDateTime.now());
        return airportService.getAllAirport();
    }

    @GetMapping("/airport/{id}")
    public Airport getAirportById(@PathVariable int id) {
        String url = "/airport/" + id;
        historyService.addToHistory("getAirportById()", url, LocalDateTime.now());
        return airportService.getAirportById(id);
    }

    @GetMapping("/airport/search")
    public List<Airport> searchAirport(@RequestParam String toSearch){
        historyService.addToHistory("searchAirport()", "airport/search", LocalDateTime.now());
        return airportService.searchAirport(toSearch);
    }

    @PostMapping("/airport/addAirport")
    public void addAirport(@RequestBody Airport airport){
        actionService.addAction("airport", "create", Map.of("id", airport.getId(), "name",  airport.getName(), "areaCode", airport.getAreaCode(), "cityId", airport.getCityId()));
        historyService.addToHistory("addAirport()", "/airport/addAirport", LocalDateTime.now());
        airportService.addAirport(airport);
    }

    @DeleteMapping("/airport/deleteAirport/{id}")
    public List<Airport> deleteAirportById(@PathVariable int id) {
        Airport airportForAction = new Airport();
        List<Airport> airportlist = airportService.getAllAirport();
        for (Airport airport : airportlist){
            if (airport.getId() == id) {
                airportForAction = airport;
            }
        }
        actionService.addAction("airport", "delete", Map.of("id", airportForAction.getId(), "name", airportForAction.getName(), "areaCode", airportForAction.getAreaCode(), "cityId", airportForAction.getCityId()));

        String url = "/airport/deleteAirport/" + id;
        historyService.addToHistory("deleteAirport()", url, LocalDateTime.now());
        return airportService.deleteAirportById(id);
    }

    @PutMapping("/airport/updateAirport/{id}")
    public List<Airport> updateAirport(@PathVariable int id, @RequestBody Airport airport){
        Airport airportForAction = new Airport();
        List<Airport> airportList = airportService.getAllAirport();
        for (Airport airportToFind : airportList){
            if (airportToFind.getId() == id) {
                airportForAction = airportToFind;
            }
        }
        actionService.addAction("airport", "update", Map.of("id", airportForAction.getId(), "name", airportForAction.getName(), "areaCode", airportForAction.getAreaCode(), "cityId", airportForAction.getCityId()));

        String url = "/airport/updateAirport/" + id;
        historyService.addToHistory("updateAirport()", url, LocalDateTime.now());
        return airportService.updateAirport(id, airport);
    }

    //relationship
    @GetMapping("/airport/getByCityId/{id}")
    public List<Airport> airportByCityId(@PathVariable int id) {
        String url = "/airport/getByCity/" + id;
        historyService.addToHistory("getAirportByCityId()", url, LocalDateTime.now());
        return airportService.airportByCityId(id);
    }

}
