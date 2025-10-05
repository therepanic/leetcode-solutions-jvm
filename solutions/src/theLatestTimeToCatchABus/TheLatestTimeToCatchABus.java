package theLatestTimeToCatchABus;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TheLatestTimeToCatchABus {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int c = 0;
        int p = 0;
        for (int b = 0; b < buses.length; b++) {
            c = 0;
            while (p < passengers.length && passengers[p] <= buses[b] && c < capacity) {
                c++;
                p++;
            }
        }
        int last = c < capacity ? buses[buses.length - 1] : passengers[p - 1];
        Set<Integer> set = new HashSet<>();
        for (int pass : passengers) {
            set.add(pass);
        }
        while (set.contains(last)) {
            last--;
        }
        return last;
    }
}
