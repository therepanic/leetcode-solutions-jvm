package gasStation;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int idx = 0;
        int sum = 0;
        int diff = 0;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            diff += gas[i] - cost[i];
            if (sum < 0) {
                sum = 0;
                idx = i + 1;
            }
        }
        if (diff < 0) return -1;
        if (idx == gas.length) return -1;
        return idx;
    }
}
