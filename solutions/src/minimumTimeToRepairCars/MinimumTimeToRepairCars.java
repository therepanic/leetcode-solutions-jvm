package minimumTimeToRepairCars;

public class MinimumTimeToRepairCars {
    public long repairCars(int[] ranks, int cars) {
        long l = 0, r =  (long) ranks[0] * cars * cars;
        while (l < r) {
            long mid = l + (r - l) / 2;
            long carsNeededForTime = 0;
            for (int rank : ranks) {
                carsNeededForTime += (long) (Math.sqrt((double) mid / rank));
            }
            if (carsNeededForTime < cars) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }
}
