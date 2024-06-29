package com.keyin.passenger;


import com.keyin.action.ActionService;
import com.keyin.aircraft.Aircraft;
import com.keyin.airport.Airport;
import com.keyin.history.HistoryService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class PassengerController {
    private final PassengerService passengerService;
    private final HistoryService historyService;
    private final ActionService actionService;

    public PassengerController(PassengerService passengerService, HistoryService historyService, ActionService actionService) {
        this.passengerService = passengerService;
        this.historyService = historyService;
        this.actionService = actionService;
    }

    @GetMapping("/passenger")
    public List<Passenger> getAllPassenger() {
        historyService.addToHistory("getAllPassenger()", "/passenger", LocalDateTime.now());
        return passengerService.getAllPassenger();
    }

    @GetMapping("/passenger/{id}")
    public Passenger getPassengerById(@PathVariable int id) {
        String url = "/passenger/" + id;
        historyService.addToHistory("getPassengerById()", url, LocalDateTime.now());
        return passengerService.getPassengerById(id);
    }

    @GetMapping("/passenger/search")
    public List<Passenger> searchPassenger(@RequestParam String toSearch){
        historyService.addToHistory("searchPassenger()", "passenger/search", LocalDateTime.now());
        return passengerService.searchPassenger(toSearch);
    }

    @PostMapping("/passenger/addPassenger")
    public void addPassenger(@RequestBody Passenger passenger){
        actionService.addAction("passenger", "create", Map.of("id", passenger.getId(), "firstname",  passenger.getFirstname(), "lastName", passenger.getLastName(), "phoneNumber", passenger.getPhoneNumber(), "aircraftIdsList", passenger.getAircraftIdsList(), "airportIdsList", passenger.getAirportIdsList()));
        historyService.addToHistory("addPassenger()", "/passenger/addPassenger", LocalDateTime.now());
        passengerService.addPassenger(passenger);
    }

    @DeleteMapping("/passenger/deletePassenger/{id}")
    public List<Passenger> deletePassengerById(@PathVariable int id) {
        Passenger passengerForAction = new Passenger();
        List<Passenger> passengerlist = passengerService.getAllPassenger();
        for (Passenger passenger : passengerlist){
            if (passenger.getId() == id) {
                passengerForAction = passenger;
            }
        }
        actionService.addAction("passenger", "delete", Map.of("id", passengerForAction.getId(), "firstname", passengerForAction.getFirstname(), "lastName", passengerForAction.getLastName(), "phoneNumber", passengerForAction.getPhoneNumber(), "aircraftIdsList", passengerForAction.getAircraftIdsList(), "airportIdsList", passengerForAction.getAirportIdsList()));

        String url = "/passenger/deletePassenger/" + id;
        historyService.addToHistory("deletePassenger()", url, LocalDateTime.now());
        return passengerService.deletePassengerById(id);
    }

    @PutMapping("/passenger/updatePassenger/{id}")
    public List<Passenger> updatePassenger(@PathVariable int id, @RequestBody Passenger passenger){
        Passenger passengerForAction = new Passenger();
        List<Passenger> passengerlist = passengerService.getAllPassenger();
        for (Passenger passengerToFind : passengerlist){
            if (passengerToFind.getId() == id) {
                passengerForAction = passengerToFind;
            }
        }
        actionService.addAction("passenger", "update", Map.of("id", passengerForAction.getId(), "firstname", passengerForAction.getFirstname(), "lastName", passengerForAction.getLastName(), "phoneNumber", passengerForAction.getPhoneNumber(), "aircraftIdsList", passengerForAction.getAircraftIdsList(), "airportIdsList", passengerForAction.getAirportIdsList()));

        String url = "/passenger/updatePassenger/" + id;
        historyService.addToHistory("updatePassenger()", url, LocalDateTime.now());
        return passengerService.updatePassenger(id, passenger);
    }

    @GetMapping("/passenger/{id}/getAircraft")
    public List<Aircraft> getAircraftPassengerTravelledOn(@PathVariable int id) {
        String url = "/passenger/"  + id + "/getAircraft";
        historyService.addToHistory("getAircraft()", url, LocalDateTime.now());
        return passengerService.getAircraft(id);
    }

    @GetMapping("/passenger/{id}/getAirport")
    public List<Airport> getAirportPassengerVisited(@PathVariable int id) {
        String url = "/passenger/"  + id + "/getAirport";
        historyService.addToHistory("getAirport()", url, LocalDateTime.now());
        return passengerService.getAirports(id);
    }
}
