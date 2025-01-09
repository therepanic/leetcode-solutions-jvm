package maximumPointsYouCanObtainFromCards;

public class MaximumPointsYouCanObtainFromCards {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;

        for (int num : cardPoints) {
            sum += num;
        }

        int minSum = Integer.MAX_VALUE;
        int curSum = 0;
        int l = 0;

        int windowSize = cardPoints.length - k;

        for (int r = 0; r < cardPoints.length; r++) {
            curSum += cardPoints[r];
            if (r - l + 1 > windowSize) {
                curSum -= cardPoints[l];
                l++;
            }

            if (r - l + 1 == windowSize) {
                minSum = Math.min(minSum, curSum);
            }
        }

        return sum - minSum;
    }
}
