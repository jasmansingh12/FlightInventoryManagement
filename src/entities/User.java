package entities;

public class User {
    String userId;
    String name;
    Integer funds;

    FlightReservation reservation;

    public FlightReservation getReservation() {
        return reservation;
    }

    public void setReservation(FlightReservation reservation) {
        this.reservation = reservation;
    }
    public User() {

    }

    public User(String userId, String name, Integer funds) {
        this.userId = userId;
        this.name = name;
        this.funds = funds;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getFunds() {
        return funds;
    }

    public void setFunds(Integer funds) {
        this.funds = funds;
    }

}
