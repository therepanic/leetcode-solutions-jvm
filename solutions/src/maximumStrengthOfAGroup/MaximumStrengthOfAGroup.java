package maximumStrengthOfAGroup;

import java.util.Arrays;

public class MaximumStrengthOfAGroup {
    public static long maxStrength(int[] nums) {
        long strength = 0;
        int minusSignalIndex = -1;
        Arrays.sort(nums);
        boolean hasZero = false;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < 0) {
                minusSignalIndex = i;
                break;
            }
            if (strength == 0) {
                strength = nums[i];
            } else if (nums[i] != 0){
                strength *= nums[i];
            }
            if (nums[i] == 0) {
                hasZero = true;
            }
        }
        boolean isMinusEven = (minusSignalIndex + 1) % 2 == 0;
        boolean isMinusActivated = false;
        if (strength == 0) {
            isMinusActivated = true;
            strength = nums[0];
        }
        for (int i = (isMinusActivated ? 1 : 0); i < minusSignalIndex + 1; i++) {
            if (i == minusSignalIndex && !isMinusEven) break;
            strength *= nums[i];
        }
        if (strength < 0 && hasZero) return 0;
        return strength;
    }
}
