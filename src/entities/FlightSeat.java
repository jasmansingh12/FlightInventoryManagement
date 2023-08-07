package entities;

public class FlightSeat extends Seat{
    Boolean isBooked;
    Integer fare;
    String bookingId;

    public FlightSeat(Boolean isBooked, Integer fare, String bookingId) {
        this.isBooked = isBooked;
        this.fare = fare;
        this.bookingId = bookingId;
    }

    public Boolean getBooked() {
        return isBooked;
    }

    public void setBooked(Boolean booked) {
        isBooked = booked;
    }

    public Integer getFare() {
        return fare;
    }

    public void setFare(Integer fare) {
        this.fare = fare;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }
}
