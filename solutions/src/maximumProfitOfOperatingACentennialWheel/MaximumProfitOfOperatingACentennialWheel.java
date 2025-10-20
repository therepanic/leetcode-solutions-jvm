package maximumProfitOfOperatingACentennialWheel;

public class MaximumProfitOfOperatingACentennialWheel {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int waiting = 0;
        int totalProfit = 0;
        int maxProfit = 0;
        int ans = -1;
        int rotations = 0;
        for (int c : customers) {
            waiting += c;
            int board = Math.min(4, waiting);
            waiting -= board;
            totalProfit += board * boardingCost - runningCost;
            rotations++;
            if (totalProfit > maxProfit) {
                maxProfit = totalProfit;
                ans = rotations;
            }
        }
        while (waiting > 0) {
            int board = Math.min(4, waiting);
            waiting -= board;
            totalProfit += board * boardingCost - runningCost;
            rotations++;
            if (totalProfit > maxProfit) {
                maxProfit = totalProfit;
                ans = rotations;
            }
        }
        return ans;
    }
}
