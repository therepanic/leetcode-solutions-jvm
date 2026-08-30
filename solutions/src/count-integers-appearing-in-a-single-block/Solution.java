import java.util.*;

class Solution {
    public int countSpecialIntegers(int[] nums) {
      Map<Integer, Integer> saved = new HashMap<>(Map.of(nums[0], 1));
      for (int i = 1; i < nums.length; i++) {
        if (nums[i] != nums[i - 1]) {
          saved.put(nums[i], saved.getOrDefault(nums[i], 0) + 1);
        }
      }
      int cnt = 0;
      for (int val : saved.values()) {
        if (val == 1) {
          cnt++;
        }
      }
    return cnt;
    }
}
