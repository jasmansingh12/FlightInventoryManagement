package services;

import entities.*;
import repository.AppData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class UserBookingService {

    private static UserManagementService userManagementService = new UserManagementService();

    public void book(String userId, String flightNumber, String departdate, String faretype, List<String> seats) {
        String bookingId = UUID.randomUUID().toString();
        ;
        Flight flights = AppData.getFlightByFlightId(flightNumber);
        List<FlightInstance> flightInstance = flights.getFlightInstances();
        List<FlightInstance> flightToBook = flightInstance.stream().filter(flightInstance1 ->
                flightInstance1.getDepartureDate().equals(departdate)).collect(Collectors.toList());
        List<FlightSeat> availableSeats = flightToBook.get(0).getFlightSeats().stream()
                .filter(flightSeat -> flightSeat.getFairType().equalsIgnoreCase(faretype))
                .collect(Collectors.toList());
        for (String seat : seats) {
            if (!availableSeats.contains(seat) &&
                    availableSeats.stream().filter(flightSeat -> flightSeat.getSeatNumber().equalsIgnoreCase(seat))
                            .collect(Collectors.toList()).get(0).getBooked() == true) {
                System.out.println("All Seats are not available to Book");
                return;
            }
        }
        for (String seat : seats) {
            List<FlightSeat> givenSeats = availableSeats.stream().filter(flightSeat -> flightSeat.getSeatNumber()
                    .equalsIgnoreCase(seat)).collect(Collectors.toList());
            List<User> users = userManagementService.getUsers();
            Integer funds = 0;
            User givenUser = new User();
            for (User user : users) {
                if (user.getUserId().equalsIgnoreCase(userId))
                    funds = user.getFunds();
                givenUser = user;
            }
            Integer amount = 0;
            for (FlightSeat flightSeat : givenSeats) {
                amount += flightSeat.getFare();
            }
            if (funds <= amount) {
                System.out.println("User has insufficient funds");
                return;
            }
            FlightReservation flightReservation = new FlightReservation();
            flightReservation.setBookingId(bookingId);
            flightReservation.setFlightInstance(flightToBook.get(0));
            HashMap<User, FlightSeat> map = new HashMap<>();


            for (FlightSeat flightSeat : givenSeats) {
                flightToBook.get(0).deleteFlightSeat(flightSeat, bookingId);
                map.put(givenUser, flightSeat);
            }
            flightReservation.setSeatMap(map);
            flightReservation.setFund(funds);
            givenUser.setReservation(flightReservation);
        }
        System.out.println("Booking Complete with id: " + bookingId);

    }

    public void cancelBooking(String uId, String bookingId) {
        List<User> users = userManagementService.getUsers();
        User guvenUser = new User();
        for (User user : users) {
            if (user.getUserId().equalsIgnoreCase(uId)) {
                guvenUser = user;
                break;
            }
        }
        FlightReservation flightReservation = guvenUser.getReservation();
        List<FlightSeat> seats = new ArrayList<>(flightReservation.getSeatMap().values());
        for (FlightSeat seat : seats) {
            seat.setBooked(false);
            seat.setBookingId(null);
        }
        guvenUser.setFunds(guvenUser.getFunds() + flightReservation.getFund());
        System.out.println("Booking cancelled");
    }

    public void getBooking(String usId) {
        List<User> users = userManagementService.getUsers();
        User givenUser = new User();
        for (User user : users) {
            if (user.getUserId().equalsIgnoreCase(usId)) {
                givenUser = user;
                break;
            }
        }
        FlightReservation flightReservation = givenUser.getReservation();
        System.out.println(flightReservation.getBookingId() + " " + flightReservation.getFlightInstance().getDepartureDate()
                + " " + flightReservation.getFlightInstance().getDepartureTime() + " " +
                flightReservation.getSeatMap().get(givenUser).getFairType() +
                flightReservation.getSeatMap().get(givenUser).getFare());
    }
}
