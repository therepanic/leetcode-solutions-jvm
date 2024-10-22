package countCompleteSubarraysInAnArray;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CountCompleteSubarraysInAnArray {
    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> characters = new HashSet<>();

        for (int num : nums) {
            characters.add(num);
        }

        Map<Integer, Integer> current = new HashMap<>();

        int r = 0;
        int l = 0;

        int count = 0;

        while (r < nums.length) {
            current.put(nums[r], current.getOrDefault(nums[r], 0) + 1);

            while (current.size() == characters.size()) {
                current.put(nums[l], current.get(nums[l]) - 1);;

                if (current.get(nums[l]) <= 0) current.remove(nums[l]);

                count += nums.length - r;

                l++;
            }

            r++;
        }
        return count;
    }
}
