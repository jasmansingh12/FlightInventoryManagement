package repository;

import entities.Flight;
import entities.User;

import java.util.HashMap;

public class AppData {
    private static HashMap<String, User> userData;
    private static HashMap<String, HashMap<String, Integer>> fareMapData;  //airline: (fairType:fare)
    private static HashMap<String, Flight> flightData;   // flightNumber: flight

    public static HashMap<String, User> getUserData() {
        return userData;
    }

    public static void setUserData(HashMap<String, User> userData) {
        AppData.userData = userData;
    }

    public static HashMap<String, HashMap<String, Integer>> getFareMapData() {
        return fareMapData;
    }

    public static void setFareMapData(HashMap<String, HashMap<String, Integer>> fareMapData) {
        AppData.fareMapData = fareMapData;
    }

    public static HashMap<String, Flight> getFlightData() {
        return flightData;
    }

    public static void setFlightData(HashMap<String, Flight> flightData) {
        AppData.flightData = flightData;
    }

    public static void addUser(User u) {
        userData.put(u.getUserId(), u);
    }

    public static Integer getFare(String airline, String fairType) {
        return fareMapData.get(airline).get(fairType);
    }

    public static Flight getFlightByFlightId(String flightId) {
        return flightData.get(flightId);
    }
}
