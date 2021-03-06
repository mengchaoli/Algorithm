import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

public class _1396_DesignUndergroundSystem {

    Map<Integer, Pair<String, Integer>> checkinMap = new HashMap<>();
    Map<String, Pair<Integer, Integer>> journeyData = new HashMap<>();

    public _1396_DesignUndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        checkinMap.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> journeyForId = checkinMap.get(id);
        String startStation = journeyForId.getKey();
        int startTime = journeyForId.getValue();
        int travelTime = t - startTime;
        String journey = generateJourney(startStation, stationName);

        Pair<Integer, Integer> journeyDataForJourney = journeyData.getOrDefault(journey, new Pair<>(0, 0));
        int totalTravelTime = journeyDataForJourney.getKey() + travelTime;
        int totalTravelNumber = journeyDataForJourney.getValue() + 1;

        journeyData.put(journey, new Pair<>(totalTravelTime, totalTravelNumber));

        checkinMap.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        String journey = generateJourney(startStation, endStation);
        int totalTravelTime = journeyData.get(journey).getKey();
        int totalTravelNumber = journeyData.get(journey).getValue();

        return (double)totalTravelTime / (double)totalTravelNumber;
    }

    private String generateJourney(String s, String e) {
        return s + "-" + e;
    }
}
