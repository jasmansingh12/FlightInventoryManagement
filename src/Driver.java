import entities.Flight;
import entities.FlightInstance;
import entities.FlightSeat;
import entities.User;
import repository.AppData;
import services.FlightManagementService;
import services.UserBookingService;
import services.UserManagementService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Driver {
    private static UserManagementService userManagementService = new UserManagementService();
    private static FlightManagementService flightManagementService = new FlightManagementService();
    private static UserBookingService userBookingService = new UserBookingService();
    private static HashMap<String, Flight> flightD = new HashMap<>();
    private static HashMap<String, HashMap<String, Integer>> fareMapData;


    public static void main(String[] args) {
        initialiseFlights();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String command = scanner.nextLine();
            String[] commandSplit = command.split(" ");
            String commandGiven = commandSplit[0];

            switch (commandGiven) {
                case "AddUser":
                    String id = commandSplit[1];
                    String name = commandSplit[2];
                    Integer funds = Integer.valueOf(commandSplit[3]);
                    userManagementService.addUser(new User(id, name, funds));
                    System.out.println("User added: " + id + " " + name + " " + funds);
                    break;
                case "SearchFlight":
                    String from = commandSplit[1];
                    String to = commandSplit[2];
                    Integer departDate = Integer.valueOf(commandSplit[3]);
                    Integer paxCount = Integer.valueOf(commandSplit[4]);
                    flightManagementService.searchFlight(from, to, departDate, paxCount);
                    break;
                case "BookFlight":
                    String userId = commandSplit[1];
                    String flightNumber = commandSplit[2];
                    String departdate = commandSplit[3];
                    String faretype = commandSplit[4];
                    List<String> seats = new ArrayList<>();
                    for (int i = 5; i < commandSplit.length; i++) {
                        seats.add(commandSplit[i]);
                    }

                    userBookingService.book(userId, flightNumber, departdate, faretype, seats);

                    break;
                case "CancelFlight":
                    String uId = commandSplit[1];
                    String bookingId = commandSplit[2];
                    userBookingService.cancelBooking(uId, bookingId);

                    break;
                case "GetUserBooking":
                    String usId = commandSplit[1];
                    userBookingService.getBooking(usId);
                    break;

                default:
                    System.out.println("Please give a valid input");
            }
        }
    }

    private static void addFlight(Boolean isBooked, Integer fare, String bookingId, Integer departureDate,
                                  Integer departureTime, Integer arrivalTime, String airline, String from,
                                  String to, String flightId, String fareType) {
        List<FlightSeat> seats = new ArrayList<>();
        List<FlightInstance> instances = new ArrayList<>();
        HashMap<String, Integer> fareMap = new HashMap<>();
        seats.add(new FlightSeat(isBooked, fare, bookingId));
        instances.add(new FlightInstance(departureDate, departureTime, arrivalTime, seats));
        flightD.put(flightId, new Flight(airline, from, to, flightId, instances));
        fareMap.put(fareType, fare);
        fareMapData.put(airline, fareMap);
    }

    private static void initialiseFlights() {
        addFlight(false, 2000, null, 2, 10, 11, "6E",
                "DEL", "BLR", "123", "F1");
        AppData.setFlightData(flightD);
        AppData.setFareMapData(fareMapData);
    }
}
