package capacityToShipPackagesWithinDDays;

public class CapacityToShipPackagesWithinDDays {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int start = 0;
        for (int weight : weights) {
            start = Math.max(weight, start);
            sum += weight;
        }
        int end = sum;
        int min = Integer.MAX_VALUE;
        while (start <= end) {
            int weightNeeded = start + (end - start) / 2;
            int daysNeeded = 1;
            int curWeight = 0;
            for (int weight : weights) {
                if (curWeight + weight > weightNeeded) {
                    daysNeeded++;
                    curWeight = weight;
                } else {
                    curWeight += weight;
                }
            }
            if (daysNeeded > days) {
                start = weightNeeded + 1;
            } else {
                min = Math.min(weightNeeded, min);
                end = weightNeeded - 1;
            }
        }
        return min;
    }
}
