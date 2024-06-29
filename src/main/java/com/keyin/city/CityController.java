package com.keyin.city;


import com.keyin.action.ActionService;
import com.keyin.history.HistoryService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class CityController {
    private final CityService cityService;
    private final HistoryService historyService;
    private final ActionService actionService;

    public CityController(CityService cityService, HistoryService historyService, ActionService actionService) {
        this.cityService = cityService;
        this.historyService = historyService;
        this.actionService = actionService;
    }

    @GetMapping("/city")
    public List<City> getAllCity() {
        historyService.addToHistory("getAllCity()", "/city", LocalDateTime.now());
        return cityService.getAllCity();
    }

    @GetMapping("/city/{id}")
    public City getCityById(@PathVariable int id) {
        String url = "/city/" + id;
        historyService.addToHistory("getCityById()", url, LocalDateTime.now());
        return cityService.getCityById(id);
    }

    @GetMapping("/city/search")
    public List<City> searchAirport(@RequestParam String toSearch){
        historyService.addToHistory("searchCity()", "city/search", LocalDateTime.now());
        return cityService.searchCity(toSearch);
    }

    @PostMapping("/city/addCity")
    public void addCity(@RequestBody City city){
        actionService.addAction("city", "create", Map.of("id", city.getId(), "name",  city.getName(), "province", city.getProvince(), "population", city.getPopulation()));
        historyService.addToHistory("addCity()", "/city/addCity", LocalDateTime.now());
        cityService.addCity(city);
    }

    @DeleteMapping("/city/deleteCity/{id}")
    public List<City> deleteCityById(@PathVariable int id) {
        City cityForAction = new City();
        List<City> citylist = cityService.getAllCity();
        for (City city : citylist){
            if (city.getId() == id) {
                cityForAction = city;
            }
        }
        actionService.addAction("city", "delete", Map.of("id", cityForAction.getId(), "name", cityForAction.getName(), "province", cityForAction.getProvince(), "population", cityForAction.getPopulation()));

        String url = "/city/deleteCity/" + id;
        historyService.addToHistory("deleteCity()", url, LocalDateTime.now());
        return cityService.deleteCityById(id);
    }

    @PutMapping("/city/updateCity/{id}")
    public List<City> updateCity(@PathVariable int id, @RequestBody City city){
        City cityForAction = new City();
        List<City> citylist = cityService.getAllCity();
        for (City cityToFind : citylist){
            if (cityToFind.getId() == id) {
                cityForAction = cityToFind;
            }
        }
        actionService.addAction("city", "update", Map.of("id", cityForAction.getId(), "name", cityForAction.getName(), "province", cityForAction.getProvince(), "population", cityForAction.getPopulation()));

        String url = "/city/updateCity/" + id;
        historyService.addToHistory("updateCity()", url, LocalDateTime.now());
        return cityService.updateCity(id, city);
    }
}
