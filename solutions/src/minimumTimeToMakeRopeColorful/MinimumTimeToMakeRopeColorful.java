package minimumTimeToMakeRopeColorful;

public class MinimumTimeToMakeRopeColorful {
    public int minCost(String colors, int[] neededTime) {
        char[] colorChars = colors.toCharArray();
        int sum = 0;
        for (int i = 1; i < colorChars.length; i++) {
            if (colorChars[i] == colorChars[i - 1]) {
                sum += Math.min(neededTime[i], neededTime[i - 1]);
                neededTime[i] = Math.max(neededTime[i], neededTime[i - 1]);
            }
        }
        return sum;
    }
}
