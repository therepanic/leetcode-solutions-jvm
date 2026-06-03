package earliestFinishTimeForLandAndWaterRidesII;

public class EarliestFinishTimeForLandAndWaterRidesII {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int minL = Integer.MAX_VALUE;
        int minW = Integer.MAX_VALUE;
        int minLAns = Integer.MAX_VALUE;
        int minWAns = Integer.MAX_VALUE;
        for (int i = 0; i < landDuration.length; i++) {
            minL = Math.min(minL, landDuration[i] + landStartTime[i]);
        }
        for (int i = 0; i < waterStartTime.length; i++) {
            minW = Math.min(minW, waterDuration[i] + waterStartTime[i]);
            minLAns = Math.min(minLAns, Math.max(waterStartTime[i], minL) + waterDuration[i]);
        }

        for (int i = 0; i < landDuration.length; i++) {
            minWAns = Math.min(minWAns, Math.max(landStartTime[i], minW) + landDuration[i]);
        }
        return Math.min(minLAns, minWAns);
    }
}
