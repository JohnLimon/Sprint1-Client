package com.keyin.http.client;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keyin.domain.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class RESTClient {

    // Aircraft methods
    public List<Aircraft> getAllAircraft() {
        List<Aircraft> aircraftList = new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/aircraft")).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("**** " + response.body() + " ****");
            } else {
                System.out.println("Error. Status Code: " + response.statusCode());
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            aircraftList = mapper.readValue(response.body(), new TypeReference<>() {
            });

        } catch (IOException | InterruptedException e ) {
            e.printStackTrace();
        }
        return aircraftList;
    }

    public Aircraft getAircraftById(int id) {
        Aircraft aircraft = new Aircraft();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/aircraft/" + id)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("**** " + response.body() + " ****");
            } else {
                System.out.println("Error. Status Code: " + response.statusCode());
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            aircraft = mapper.readValue(response.body(), new TypeReference<>() {
            });

        } catch (IOException | InterruptedException e ) {
            e.printStackTrace();
        }
        return aircraft;
    }

    // Airport methods
    public List<Airport> getAllAirport(){
        List<Airport> airportList = new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/airport")).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("**** " + response.body() + " ****");
            } else {
                System.out.println("Error. Status Code: " + response.statusCode());
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            airportList = mapper.readValue(response.body(), new TypeReference<>() {
            });

        } catch (IOException | InterruptedException e ) {
            e.printStackTrace();
        }

        return airportList;
    }

    public Airport getAirportById(int id) {
        Airport airport = new Airport();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/airport/" + id)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("**** " + response.body() + " ****");
            } else {
                System.out.println("Error. Status Code: " + response.statusCode());
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            airport = mapper.readValue(response.body(), new TypeReference<Airport>(){});

        } catch (IOException | InterruptedException e ) {
            e.printStackTrace();
        }
        return airport;
    }

    public List<Airport> getAirportsByCityId(int id){
        List<Airport> airportList = new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/airport/getByCityId/" + id)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("**** " + response.body() + " ****");
            } else {
                System.out.println("Error. Status Code: " + response.statusCode());
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            airportList = mapper.readValue(response.body(), new TypeReference<List<Airport>>(){});

        } catch (IOException | InterruptedException e ) {
            e.printStackTrace();
        }

        return airportList;
    }

    //------------------------------------------------------------------------------------------------------------------
    // City methods

    public List<City> getAllCity(){
        List<City> cityList = new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/city")).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("**** " + response.body() + " ****");
            } else {
                System.out.println("Error. Status Code: " + response.statusCode());
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            cityList = mapper.readValue(response.body(), new TypeReference<List<City>>(){});

        } catch (IOException | InterruptedException e ) {
            e.printStackTrace();
        }

        return cityList;
    }

    public City getCityById(int id) {
        City city = new City();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/city/" + id)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("**** " + response.body() + " ****");
            } else {
                System.out.println("Error. Status Code: " + response.statusCode());
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            city = mapper.readValue(response.body(), new TypeReference<City>(){});

        } catch (IOException | InterruptedException e ) {
            e.printStackTrace();
        }
        return city;
    }

    //------------------------------------------------------------------------------------------------------------------
    // Passenger methods

    public List<Passenger> getAllPassenger(){
        List<Passenger> passengerList = new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/passenger")).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("**** " + response.body() + " ****");
            } else {
                System.out.println("Error. Status Code: " + response.statusCode());
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            passengerList = mapper.readValue(response.body(), new TypeReference<List<Passenger>>(){});

        } catch (IOException | InterruptedException e ) {
            e.printStackTrace();
        }

        return passengerList;
    }

    public Passenger getPassengerById(int id) {
        Passenger passenger = new Passenger();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/passenger/" + id)).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("**** " + response.body() + " ****");
            } else {
                System.out.println("Error. Status Code: " + response.statusCode());
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            passenger = mapper.readValue(response.body(), new TypeReference<Passenger>(){});

        } catch (IOException | InterruptedException e ) {
            e.printStackTrace();
        }
        return passenger;
    }

    public List<Aircraft> getAircraftPassengerBeenOn(int id) {
        List<Aircraft> aircraftList = new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/passenger/" + id + "/getAircraft")).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("**** " + response.body() + " ****");
            } else {
                System.out.println("Error. Status Code: " + response.statusCode());
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            aircraftList = mapper.readValue(response.body(), new TypeReference<List<Aircraft>>(){});

        } catch (IOException | InterruptedException e ) {
            e.printStackTrace();
        }

        return aircraftList;
    }

    public List<Airport> getAirportPassengerVisited(int id) {
        List<Airport> airportList = new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/passenger/" + id + "/getAirport")).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("**** " + response.body() + " ****");
            } else {
                System.out.println("Error. Status Code: " + response.statusCode());
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            airportList = mapper.readValue(response.body(), new TypeReference<List<Airport>>(){});

        } catch (IOException | InterruptedException e ) {
            e.printStackTrace();
        }

        return airportList;
    }

    //------------------------------------------------------------------------------------------------------------------
    // actions

    public History getHistoryPeek(){
        History history = new History();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/history")).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("**** " + response.body() + " ****");
            } else {
                System.out.println("Error. Status Code: " + response.statusCode());
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            history = mapper.readValue(response.body(), new TypeReference<History>(){});

        } catch (IOException | InterruptedException e ) {
            e.printStackTrace();
        }
        return history;
    }

    public List<History> getAllHistory(){
        List<History> historyList = new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/allHistory")).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("**** " + response.body() + " ****");
            } else {
                System.out.println("Error. Status Code: " + response.statusCode());
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            historyList = mapper.readValue(response.body(), new TypeReference<List<History>>(){});

        } catch (IOException | InterruptedException e ) {
            e.printStackTrace();
        }

        return historyList;
    }

    public History undoHistory(){
        History history = new History();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/undoHistory")).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("**** " + response.body() + " ****");
            } else {
                System.out.println("Error. Status Code: " + response.statusCode());
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            history = mapper.readValue(response.body(), new TypeReference<History>(){});

        } catch (IOException | InterruptedException e ) {
            e.printStackTrace();
        }
        return history;
    }

    public History redoHistory(){
        History history = new History();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/redoHistory")).build();

        try {
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                System.out.println("**** " + response.body() + " ****");
            } else {
                System.out.println("Error. Status Code: " + response.statusCode());
            }

            ObjectMapper mapper = new ObjectMapper();
            mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            history = mapper.readValue(response.body(), new TypeReference<History>(){});

        } catch (IOException | InterruptedException e ) {
            e.printStackTrace();
        }
        return history;
    }



}
