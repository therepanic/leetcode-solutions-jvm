package maximizeSumOfDeviceRatings;

public class MaximizeSumOfDeviceRatings {
    public long maxRatings(int[][] units) {
        long min1 = Integer.MAX_VALUE;
        long min2 = Integer.MAX_VALUE;
        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < units.length; i++) {
            long curMin1 = Integer.MAX_VALUE;
            long curMin2 = Integer.MAX_VALUE;
            for (int j = 0; j < units[i].length; j++) {
                if (units[i][j] < curMin1) {
                    curMin2 = curMin1;
                    curMin1 = units[i][j];
                } else if (units[i][j] < curMin2) {
                    curMin2 = units[i][j];
                }
            }
            if (units[i].length == 1) {
                curMin2 = 0;
            }
            sum1 += curMin1;
            sum2 += curMin2;
            min1 = Math.min(min1, curMin1);
            min2 = Math.min(min2, curMin2);
        }
        return Math.max(sum1, min1 + sum2 - min2);
    }
}
