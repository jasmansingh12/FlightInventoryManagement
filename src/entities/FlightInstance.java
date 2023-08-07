package entities;

import java.util.List;
import java.util.stream.Collectors;

public class FlightInstance {
    Integer departureDate;
    Integer departureTime;
    Integer arrivalTime;

    List<FlightSeat> flightSeats;

    public FlightInstance(Integer departureDate, Integer departureTime, Integer arrivalTime, List<FlightSeat> flightSeats) {
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.flightSeats = flightSeats;
    }

    public Integer getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(Integer departureDate) {
        this.departureDate = departureDate;
    }

    public Integer getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Integer departureTime) {
        this.departureTime = departureTime;
    }

    public Integer getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Integer arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public List<FlightSeat> getFlightSeats() {
        return flightSeats;
    }

    public void deleteFlightSeat(FlightSeat f, String bookingId) {
        List<FlightSeat> flightSeats1 = flightSeats.stream().filter(flightSeat -> flightSeat.getSeatNumber().equalsIgnoreCase(f.seatNumber))
                .collect(Collectors.toList());
        flightSeats1.get(0).setBooked(true);
        flightSeats1.get(0).setBookingId(bookingId);
    }

    public void setFlightSeats(List<FlightSeat> flightSeats) {
        this.flightSeats = flightSeats;
    }


}
