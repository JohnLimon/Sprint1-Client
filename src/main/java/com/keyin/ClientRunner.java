package com.keyin;

import com.keyin.http.cli.HTTPRestCLIApplication;
import com.keyin.http.client.RESTClient;

public class ClientRunner {
    public static void main(String[] args) {

        // make a switch statement here to take in commandline arguments ***********************************************

        HTTPRestCLIApplication cliApp = new HTTPRestCLIApplication();

        cliApp.setRestClient(new RESTClient());



        if (args.length > 0) {

            switch (args[0]) {

                // Aircraft commands
                case "aircraft":
                    cliApp.generateAircraftReport();
                    break;
                case "aircraftById":
                    cliApp.getAircraftByIdReport(Integer.parseInt(args[1]));
                    break;

                // Airport commands
                case "airport":
                    cliApp.generateAirportReport();
                    break;
                case "airportById":
                    cliApp.getAirportByIdReport(Integer.parseInt(args[1]));
                    break;
                case "airportByCityId":
                    cliApp.getAirportsByCityIdReport(Integer.parseInt(args[1]));
                    break;

                // City commands
                case "city":
                    cliApp.generateCityReport();
                    break;
                case "cityById":
                    cliApp.getCityByIdReport(Integer.parseInt(args[1]));
                    break;

                // Passenger commands
                case "passenger":
                    cliApp.generatePassengerReport();
                    break;
                case "passengerById":
                    cliApp.getPassengerByIdReport(Integer.parseInt(args[1]));
                    break;
                case "passengerAircraft":
                    cliApp.getAircraftPassengerBeenOnReport(Integer.parseInt(args[1]));
                    break;
                case "passengerAirport":
                    cliApp.getAirportPassengerVisitedReport(Integer.parseInt(args[1]));
                    break;

                // History commands
                case "history":
                    cliApp.getHistoryPeekReport();
                    break;
                case "allHistory":
                    cliApp.getAllHistoryReport();
                    break;
                case "undoHistory":
                    cliApp.getUndoHistory();
                    break;
                case "redoHistory":
                    cliApp.getRedoHistory();
                    break;
                default:
                    System.out.println();
                    System.out.println("** Sorry, Unknown args **");
            }
        } else {
            System.out.println();
            System.out.println("** You must edit configuration and add arguments to access data ** ");
        }

    }
}
