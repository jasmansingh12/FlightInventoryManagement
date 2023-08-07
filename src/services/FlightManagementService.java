package services;

import entities.Flight;
import entities.FlightInstance;
import entities.FlightSeat;
import repository.AppData;

import java.net.StandardSocketOptions;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class FlightManagementService {
    public void searchFlight(String from, String to, Integer departDate, Integer paxCount) {
        HashMap<String, Flight> flightData = AppData.getFlightData();
        List<Flight> flights = new ArrayList<>(flightData.values());
        List<Flight> availableFlights = flights.stream().filter(flight -> flight.getFrom().equalsIgnoreCase(from) &&
                        flight.getTo().equalsIgnoreCase(to))
                .collect(Collectors.toList());

        for (Flight flight : availableFlights) {
            List<FlightInstance> flightInstances = flight.getFlightInstances();
            for (FlightInstance flightInstance : flightInstances) {
                if (flightInstance.getDepartureDate().equals(departDate) &&
                        flightInstance.getFlightSeats().size() >= paxCount) {
                    System.out.println(flight.getFlightId() + " " + flight.getAirline() + " "
                            + from + " " + to + " " + flightInstance.getDepartureTime() + " "
                            + flightInstance.getFlightSeats().get(0).getFare() + " " +
                            flightInstance.getFlightSeats().get(0).getFairType());
                    for (FlightSeat seat : flightInstance.getFlightSeats()) {
                        System.out.println(seat.getSeatNumber() + " ");
                    }
                }
            }
        }

    }
}
