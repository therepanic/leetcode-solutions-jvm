package checkIfArrayPairsAreDivisibleByK;

import java.util.HashMap;
import java.util.Map;

public class CheckIfArrayPairsAreDivisibleByK {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> pref = new HashMap<>();
        for (int x : arr) {
            int r = ((x % k) + k) % k;
            pref.put(r, pref.getOrDefault(r, 0) + 1);
        }
        if (pref.getOrDefault(0, 0) % 2 != 0) {
            return false;
        }
        for (int i = 1; i <= k / 2; i++) {
            if (!pref.getOrDefault(i, 0).equals(pref.getOrDefault(k - i, 0))) {
                return false;
            }
        }
        return true;
    }

}
