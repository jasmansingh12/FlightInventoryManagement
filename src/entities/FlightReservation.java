package entities;

import java.util.HashMap;

public class FlightReservation {
    HashMap<User, FlightSeat> seatMap;
    String reservationNumber;
    FlightInstance flightInstance;

    public Integer getFund() {
        return fund;
    }

    public void setFund(Integer fund) {
        this.fund = fund;
    }

    String bookingId;

    Integer fund;

    public HashMap<User, FlightSeat> getSeatMap() {
        return seatMap;
    }

    public void setSeatMap(HashMap<User, FlightSeat> seatMap) {
        this.seatMap = seatMap;
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public void setReservationNumber(String reservationNumber) {
        this.reservationNumber = reservationNumber;
    }

    public FlightInstance getFlightInstance() {
        return flightInstance;
    }

    public void setFlightInstance(FlightInstance flightInstance) {
        this.flightInstance = flightInstance;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }
}
