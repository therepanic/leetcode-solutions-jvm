package bestSightseeingPair;

public class BestSightseeingPair {
    public static int maxScoreSightseeingPair(int[] values) {
        int maxScore = 0;

        int maxI = 0;

        for (int i = 0; i < values.length; i++) {
            maxScore = Math.max(maxScore, maxI + values[i] - i);
            maxI = Math.max(maxI, values[i] + i);
        }

        return maxScore;
    }
}
