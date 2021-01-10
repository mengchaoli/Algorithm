import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class _1396_DesignUndergroundSystem {
    Map<String, Pair<Integer, Integer>> journeyData = new HashMap<>();
    Map<Integer, Pair<String, Integer>> checkinMap = new HashMap<>();

    public _1396_DesignUndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        checkinMap.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> startStationForId = checkinMap.get(id);
        String startStation = startStationForId.getKey();
        String journey = generateJourney(startStation, stationName);
        int travelTime = t - startStationForId.getValue();
        int totalTravelTime = journeyData.getOrDefault(journey, new Pair<>(0, 0)).getKey() + travelTime;
        int totalTravelNumber = journeyData.getOrDefault(journey, new Pair<>(0, 0)).getValue() + 1;

        journeyData.put(journey, new Pair<>(totalTravelTime, totalTravelNumber));

        checkinMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String journey = generateJourney(startStation, endStation);
        int time = journeyData.get(journey).getKey();
        int number = journeyData.get(journey).getValue();

        return (double)time / (double)number;
    }

    private String generateJourney(String startStation, String endStation) {
        return startStation + "-" + endStation;
    }
}
