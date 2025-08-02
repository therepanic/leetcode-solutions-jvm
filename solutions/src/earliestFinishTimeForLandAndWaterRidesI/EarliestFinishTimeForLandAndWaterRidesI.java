package earliestFinishTimeForLandAndWaterRidesI;

public class EarliestFinishTimeForLandAndWaterRidesI {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < landStartTime.length; i++) {
            for (int j = 0; j < waterStartTime.length; j++) {
                int startWater = Math.max(landStartTime[i] + landDuration[i], waterStartTime[j]);
                int total = startWater + waterDuration[j];
                min = Math.min(min, total);
            }
        }
        for (int i = 0; i < waterStartTime.length; i++) {
            for (int j = 0; j < landStartTime.length; j++) {
                int startLand = Math.max(waterStartTime[i] + waterDuration[i], landStartTime[j]);
                int total = startLand + landDuration[j];
                min = Math.min(min, total);
            }
        }
        return min;
    }
}
