package entities;

import java.util.List;

public class Flight {
    String airline;
    String from;
    String to;
    String flightId;
    List<FlightInstance> flightInstances;

    public Flight(String airline, String from, String to, String flightId, List<FlightInstance> flightInstances) {
        this.airline = airline;
        this.from = from;
        this.to = to;
        this.flightId = flightId;
        this.flightInstances = flightInstances;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getFlightId() {
        return flightId;
    }

    public void setFlightId(String flightId) {
        this.flightId = flightId;
    }

    public List<FlightInstance> getFlightInstances() {
        return flightInstances;
    }

    public void setFlightInstances(List<FlightInstance> flightInstances) {
        this.flightInstances = flightInstances;
    }


}
