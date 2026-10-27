package countFrequencyStaircaseSubarraysI;

import java.util.*;

public class CountFrequencyStaircaseSubarraysI {
    public int countStaircase(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            Map<Integer, Integer> freq = new HashMap<>();
            Map<Integer, Integer> need = new HashMap<>();
            int c = 1;
            int block = 0;
            for (int j = i; j < nums.length; j++) {
                int v = nums[j];
                if (!need.containsKey(v)) {
                    need.put(v, c++);
                    block++;
                }
                int a = freq.getOrDefault(v, 0);
                freq.put(v, a + 1);
                if (a == need.get(v)) {
                    break;
                }
                if (freq.get(v).equals(need.get(v))) {
                    block--;
                }
                if (block == 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
