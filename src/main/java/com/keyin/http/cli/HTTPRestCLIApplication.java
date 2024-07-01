package com.keyin.http.cli;

import com.keyin.domain.*;
import com.keyin.http.client.RESTClient;

import java.util.List;

public class HTTPRestCLIApplication {

    private RESTClient restClient;

    public RESTClient getRestClient() {
        if (restClient == null) {
            restClient = new RESTClient();
        }
        return restClient;
    }

    public void setRestClient(RESTClient restClient) {
        this.restClient = restClient;
    }

    // Aircraft methods
    public String generateAircraftReport() {
        List<Aircraft> aircraftList = getRestClient().getAllAircraft();
        StringBuilder report = new StringBuilder();

        for (Aircraft aircraft : aircraftList) {
            report.append(aircraft.getType());
            report.append(" - ");
            report.append(aircraft.getAirlineName());

            if (aircraftList.indexOf(aircraft) != (aircraftList.size() - 1)) {
                report.append(", ");
            }
        }
        System.out.println("All aircraft's");
        System.out.println(report);
        return report.toString();
    }

    public void getAircraftByIdReport(int id) {
        Aircraft aircraft = getRestClient().getAircraftById(id);
        StringBuilder report = new StringBuilder();
        report.append(aircraft.getType());
        report.append(" - ");
        report.append(aircraft.getAirlineName());
        if (aircraft.getType() != null ) {
            System.out.println("Aircraft with id: " + id);
            System.out.println(report);
        } else {
            System.out.println("There are no aircraft's with id: " + id);
        }

    }

    //------------------------------------------------------------------------------------------------------------------
    // Airport methods

    public String generateAirportReport() {
        List<Airport> airportList = getRestClient().getAllAirport();
        StringBuilder report = new StringBuilder();

        for (Airport airport : airportList) {
            report.append(airport.getName());
            report.append(" - ");
            report.append(airport.getAreaCode());

            if (airportList.indexOf(airport) != (airportList.size() - 1)) {
                report.append(", ");
            }
        }
        System.out.println("All airports");
        System.out.println(report);
        return report.toString();
    }

    public void getAirportByIdReport(int id) {
        Airport airport = getRestClient().getAirportById(id);
        StringBuilder report = new StringBuilder();
        report.append(airport.getName());
        report.append(" - ");
        report.append(airport.getAreaCode());
        if (airport.getName() != null) {
            System.out.println("Airport with id: " + id);
            System.out.println(report);
        } else {
            System.out.println("There are no airports with id: " + id);
        }

    }

    public void getAirportsByCityIdReport(int id) {
        List<Airport> airportList = getRestClient().getAirportsByCityId(id);
        StringBuilder report = new StringBuilder();

        for (Airport airport : airportList) {
            report.append(airport.getName());
            report.append(" - ");
            report.append(airport.getAreaCode());

            if (airportList.indexOf(airport) != (airportList.size() - 1)) {
                report.append(", ");
            }
        }
        if(report.length() <= 0){
            System.out.println("There are no airports in the city with id: " + id);
        } else {
            System.out.println("All airports in the city with id: " + id);
            System.out.println(report);
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    // City methods

    public String generateCityReport() {
        List<City> cityList = getRestClient().getAllCity();
        StringBuilder report = new StringBuilder();

        for (City city : cityList) {
            report.append(city.getName());
            report.append(" - ");
            report.append(city.getProvince());

            if (cityList.indexOf(city) != (cityList.size() - 1)) {
                report.append(", ");
            }
        }
        System.out.println("All cities");
        System.out.println(report);
        return report.toString();
    }

    public void getCityByIdReport(int id) {
        City city = getRestClient().getCityById(id);
        StringBuilder report = new StringBuilder();
        report.append(city.getName());
        report.append(" - ");
        report.append(city.getProvince());
        if (city.getName() != null){
            System.out.println("City with id: " + id);
            System.out.println(report);
        } else {
            System.out.println("There is not city with id: " + id);
        }
    }

    //------------------------------------------------------------------------------------------------------------------
    // Passenger methods

    public String generatePassengerReport() {
        List<Passenger> passengerList = getRestClient().getAllPassenger();
        StringBuilder report = new StringBuilder();

        for (Passenger passenger : passengerList) {
            report.append(passenger.getFirstname()).append(" ").append(passenger.getLastName());
            report.append(" - ");
            report.append(passenger.getPhoneNumber());

            if (passengerList.indexOf(passenger) != (passengerList.size() - 1)) {
                report.append(", ");
            }
        }
        System.out.println("All passengers");
        System.out.println(report);
        return report.toString();
    }

    public void getPassengerByIdReport(int id) {
        Passenger passenger = getRestClient().getPassengerById(id);
        StringBuilder report = new StringBuilder();
        report.append(passenger.getFirstname()).append(" ").append(passenger.getLastName());
        report.append(" - ");
        report.append(passenger.getPhoneNumber());

        if (passenger.getFirstname() != null){
            System.out.println("Passenger with id: " + id);
            System.out.println(report);
        } else {
            System.out.println("There is no passenger with id: " + id);
        }

    }

    public void getAircraftPassengerBeenOnReport(int id) {
        List<Aircraft> aircraftList = getRestClient().getAircraftPassengerBeenOn(id);
        StringBuilder report = new StringBuilder();

        for (Aircraft aircraft : aircraftList) {
            report.append(aircraft.getType());
            report.append(" - ");
            report.append(aircraft.getAirlineName());

            if (aircraftList.indexOf(aircraft) != (aircraftList.size() - 1)) {
                report.append(", ");
            }
        }

        if(report.length() <= 0){
            System.out.println("The passenger with id: " + id + " has not been on any planes");
        } else {
            System.out.println("All aircraft's passenger with id: " + id + " has been on");
            System.out.println(report);
        }

    }

    public void getAirportPassengerVisitedReport(int id) {
        List<Airport> airportList = getRestClient().getAirportPassengerVisited(id);
        StringBuilder report = new StringBuilder();

        for (Airport airport : airportList) {
            report.append(airport.getName());
            report.append(" - ");
            report.append(airport.getAreaCode());

            if (airportList.indexOf(airport) != (airportList.size() - 1)) {
                report.append(", ");
            }
        }

        if(report.length() <= 0){
            System.out.println("The passenger with id: " + id + " has not been on any airports");
        } else {
            System.out.println("All airports passenger with id: " + id + " has visited");
            System.out.println(report);
        }
    }


    //------------------------------------------------------------------------------------------------------------------
    // Actions

    public void getHistoryPeekReport() {
        History history = getRestClient().getHistoryPeek();

        StringBuilder report = new StringBuilder();
        report.append(history.getCalledMethod());
        report.append(" - ");
        report.append(history.getUrl());
        report.append(" - ");
        report.append(history.getTimestamp());

        if (history.getCalledMethod() != null){
            System.out.println("The last request made to the server");
            System.out.println(report);
        } else {
            System.out.println("No requests have been made to the server yet, the history stack is empty");
        }
    }

    public String getAllHistoryReport() {
        List<History> historyList = getRestClient().getAllHistory();
        StringBuilder report = new StringBuilder();

        for (History history : historyList) {
            report.append(history.getCalledMethod());
            report.append(" - ");
            report.append(history.getUrl());
            report.append(" - ");
            report.append(history.getTimestamp());

            if (historyList.indexOf(history) != (historyList.size() - 1)) {
                report.append(", ");
            }
        }

        if (report.length() <= 0){
            System.out.println("No requests have been made to the server yet, the history stack is empty");
            System.out.println(report);
        } else {
            System.out.println("All requests made to the server");
            System.out.println(report);
        }
        return report.toString();
    }

    public void getUndoHistory() {
        History history = getRestClient().undoHistory();

        StringBuilder report = new StringBuilder();
        report.append(history.getCalledMethod());
        report.append(" - ");
        report.append(history.getUrl());
        report.append(" - ");
        report.append(history.getTimestamp());

        if (history.getCalledMethod() != null){
            System.out.println("The last request made to the server");
            System.out.println(report);
        } else {
            System.out.println("cannot undo any further the history stack is empty");
        }
    }

    public void getRedoHistory() {
        History history = getRestClient().redoHistory();

        StringBuilder report = new StringBuilder();
        report.append(history.getCalledMethod());
        report.append(" - ");
        report.append(history.getUrl());
        report.append(" - ");
        report.append(history.getTimestamp());

        if (history.getCalledMethod() != null){
            System.out.println("The last request made to the server");
            System.out.println(report);
        } else {
            System.out.println("cannot redo any further you reached the top of the history stack");
        }
    }

}

