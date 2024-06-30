package com.keyin.passenger;

import com.keyin.aircraft.Aircraft;
import com.keyin.aircraft.AircraftService;
import com.keyin.airport.Airport;
import com.keyin.airport.AirportService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PassengerService {
    private final List<Passenger> passengerList = new ArrayList<>();

    public PassengerService() {
        populate();
    }

    public void populate(){
        Passenger passenger1 = new Passenger();
        passenger1.setId(1);
        passenger1.setFirstname("Jelliebeth");
        passenger1.setLastName("Sevilla");
        passenger1.setPhoneNumber("(709) 123-4567");
        passenger1.addToAircraftIdsList(1);
        passenger1.addToAirportIdsList(1);
        passenger1.addToAirportIdsList(2);
        passengerList.add(passenger1);

        Passenger passenger2 = new Passenger();
        passenger2 .setId(2);
        passenger2 .setFirstname("John");
        passenger2 .setLastName("Limon");
        passenger2 .setPhoneNumber("(709) 987-6543");
        passenger2.addToAircraftIdsList(1);
        passenger2.addToAircraftIdsList(2);
        passenger2.addToAirportIdsList(2);
        passenger2.addToAirportIdsList(3);
        passengerList.add(passenger2 );

        Passenger passenger3 = new Passenger();
        passenger3.setId(3);
        passenger3.setFirstname("Jhailla");
        passenger3.setLastName("Nunez");
        passenger3.setPhoneNumber("(709) 222-3333");
        passengerList.add(passenger3);

        Passenger passenger4 = new Passenger();
        passenger4.setId(4);
        passenger4.setFirstname("Jhaille");
        passenger4.setLastName("Nunez");
        passenger4.setPhoneNumber("(709) 444-5555");
        passenger4.addToAircraftIdsList(4);
        passenger4.addToAircraftIdsList(5);
        passenger4.addToAirportIdsList(4);
        passenger4.addToAirportIdsList(6);
        passengerList.add(passenger4);

        Passenger passenger5 = new Passenger();
        passenger5.setId(5);
        passenger5.setFirstname("Jhann");
        passenger5.setLastName("Vargas");
        passenger5.setPhoneNumber("(709) 777-6666");
        passenger5.addToAircraftIdsList(7);
        passenger5.addToAircraftIdsList(8);
        passenger5.addToAirportIdsList(8);
        passenger5.addToAirportIdsList(9);
        passengerList.add(passenger5);

        Passenger passenger6 = new Passenger();
        passenger6.setId(6);
        passenger6.setFirstname("Jhanna");
        passenger6.setLastName("Vargas");
        passenger6.setPhoneNumber("(709) 111-2222");
        passenger6.addToAircraftIdsList(3);
        passenger6.addToAircraftIdsList(2);
        passenger6.addToAirportIdsList(1);
        passenger6.addToAirportIdsList(2);
        passenger6.addToAirportIdsList(2);
        passengerList.add(passenger6);

        Passenger passenger7 = new Passenger();
        passenger7.setId(7);
        passenger7.setFirstname("Zoie");
        passenger7.setLastName("Obra");
        passenger7.setPhoneNumber("(709) 999-8888");
        passenger7.addToAircraftIdsList(1);
        passenger7.addToAirportIdsList(1);
        passengerList.add(passenger7);

        Passenger passenger8 = new Passenger();
        passenger8.setId(8);
        passenger8.setFirstname("Zeia");
        passenger8.setLastName("Obra");
        passenger8.setPhoneNumber("(709) 444-8888");
        passengerList.add(passenger8);
    }

    public List<Passenger> getAllPassenger() {
        return passengerList;
    }

    public Passenger getPassengerById(int id) {

        Passenger foundPassenger = new Passenger();

        for (Passenger passenger : passengerList) {
            if (passenger.getId() == id) {
                foundPassenger = passenger;
                return foundPassenger;
            }
        }
        return foundPassenger;
    }

    public List<Passenger> searchPassenger(String toSearch){

        List<Passenger> foundList = new ArrayList<>();

        for (Passenger passenger : passengerList) {
            String idToString = String.valueOf(passenger.getId());

            if(idToString.equals(toSearch) || passenger.getFirstname().equals(toSearch) || passenger.getLastName().equals(toSearch) || passenger.getPhoneNumber().equals(toSearch)) {
                foundList.add(passenger);

            }
        }
        return foundList;
    }

    public void addPassenger(Passenger passenger){
        passengerList.add(passenger);
    }

    public List<Passenger> updatePassenger(int id, Passenger passengerToChange){
        boolean found = false;

        for(Passenger passenger : passengerList) {
            if(passenger.getId() == id){
                passenger.setFirstname(passengerToChange.getFirstname());
                passenger.setLastName(passengerToChange.getLastName());
                passenger.setPhoneNumber(passengerToChange.getPhoneNumber());
                passenger.setAircraftIdsList(passengerToChange.getAircraftIdsList());
                passenger.setAirportIdsList(passengerToChange.getAirportIdsList());
                found = true;
            }
        }
        if(!found) {
            System.out.println("Sorry, this passenger does not exist.");
        }
        return passengerList;
    }

    public List<Passenger> deletePassengerById(int id) {

        boolean found = false;

        for (Passenger passenger : passengerList) {
            if (passenger.getId() == id) {
                passengerList.remove(passenger);
                //found = true;
                System.out.println("The airport has been deleted");
                return passengerList;
            }
        }
        if (!found){
            System.out.println("Sorry the passenger you are trying to delete does not exist.");
        }
        return passengerList;
    }

    public List<Aircraft> getAircraft(int id){
        List<Aircraft> allAircraftList;
        AircraftService aircraftService = new AircraftService();
        allAircraftList = aircraftService.getAllAircraft();

        List<Aircraft> aircraftFlownOn = new ArrayList<>();

        Passenger foundPassenger = new Passenger();

        for(Passenger passenger: passengerList) {
            if (id == passenger.getId()) {
                foundPassenger = passenger;
            }
        }

        for(Integer i : foundPassenger.getAircraftIdsList() ) {
            for(Aircraft aircraft : allAircraftList) {
                if(i == aircraft.getId()) {
                    aircraftFlownOn.add(aircraft);
                }
            }
        }

        return aircraftFlownOn;
    }

    public List<Airport> getAirports(int id) {
        List<Airport> allAirportsList;
        AirportService airportService = new AirportService();
        allAirportsList = airportService.getAllAirport();

        List<Airport> airportVisited = new ArrayList<>();

        Passenger foundPassenger = new Passenger();

        for(Passenger passenger : passengerList) {
            if (id == passenger.getId()) {
                foundPassenger = passenger;
            }
        }

        for(Integer i : foundPassenger.getAirportIdsList() ) {
            for(Airport airport : allAirportsList) {
                if(i == airport.getId()) {
                    airportVisited.add(airport);
                }
            }
        }

        return airportVisited;
    }
}
