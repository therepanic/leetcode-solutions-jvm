package splitArrayLargestSum;

public class SplitArrayLargestSum {
    public int splitArray(int[] nums, int k) {
        int sum = 0;
        int max = 0;
        int start = 0;
        for (int weight : nums) {
            start = Math.max(weight, start);
            max = start;
            sum += weight;
        }
        int end = sum;
        int min = Integer.MAX_VALUE;
        while (start <= end) {
            int weightNeeded = start + (end - start) / 2;
            int daysNeeded = 1;
            int curWeight = 0;
            for (int weight : nums) {
                if (curWeight + weight > weightNeeded) {
                    daysNeeded++;
                    curWeight = weight;
                } else {
                    curWeight += weight;
                }
            }
            if (daysNeeded > k) {
                start = weightNeeded + 1;
            } else {
                if (daysNeeded == k) {
                    min = Math.min(weightNeeded, min);
                }
                end = weightNeeded - 1;
            }
        }
        return min == Integer.MAX_VALUE ? max : min;
    }
}
