package randomPickIndex;

import java.util.*;

public class RandomPickIndex {

    private final Map<Integer, List<Integer>> valueMap;

    private final Random random;

    public RandomPickIndex(int[] nums) {
        this.valueMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            this.valueMap.computeIfAbsent(val, (key) -> new ArrayList<>()).add(i);
        }
        this.random = new Random();
    }

    public int pick(int target) {
        return this.valueMap.get(target).get(this.random.nextInt(this.valueMap.get(target).size()));
    }

}
