package designUndergroundSystem;

import java.util.*;

public class DesignUndergroundSystem {
    private static class Pair<T, L> {
        public T firstValue;
        public L secondValue;

        public Pair(T firstValue, L secondValue) {
            this.firstValue = firstValue;
            this.secondValue = secondValue;
        }
    }


    private final Map<Integer, Pair<String, Integer>> cardIdStationNameTimeMap = new HashMap<>();
    private final Map<String, Map<String, List<Integer>>> checkInStationCheckOutStationAverageTimeMap = new HashMap<>();
    public DesignUndergroundSystem() {
    }

    public void checkIn(int id, String stationName, int t) {
        cardIdStationNameTimeMap.put(id, new Pair<>(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        Pair<String, Integer> stationNameTimePair = cardIdStationNameTimeMap.get(id);

        cardIdStationNameTimeMap.remove(id);

        if (!checkInStationCheckOutStationAverageTimeMap.containsKey(stationNameTimePair.firstValue)) {
            checkInStationCheckOutStationAverageTimeMap.put(stationNameTimePair.firstValue, new HashMap<>(
                    Map.of(stationName, new LinkedList<>(List.of(Math.abs(stationNameTimePair.secondValue - t)))))
            );
        } else {
            if (!checkInStationCheckOutStationAverageTimeMap.get(stationNameTimePair.firstValue)
                    .containsKey(stationName)) {
                checkInStationCheckOutStationAverageTimeMap.get(stationNameTimePair.firstValue)
                        .put(stationName, new LinkedList<>(List.of(Math.abs(stationNameTimePair.secondValue - t))));
            } else {
                checkInStationCheckOutStationAverageTimeMap.get(stationNameTimePair.firstValue)
                        .get(stationName).add(Math.abs(stationNameTimePair.secondValue - t));
            }
        }
    }

    public double getAverageTime(String startStation, String endStation) {
        double averageTime = 0;

        List<Integer> startStationEndStationOutTimes = checkInStationCheckOutStationAverageTimeMap.get(startStation)
                .get(endStation);

        for (int time : startStationEndStationOutTimes) {
            averageTime += time;
        }

        averageTime /= startStationEndStationOutTimes.size();

        return averageTime;
    }
}
