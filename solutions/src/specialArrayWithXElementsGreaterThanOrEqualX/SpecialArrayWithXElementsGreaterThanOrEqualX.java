package specialArrayWithXElementsGreaterThanOrEqualX;

public class SpecialArrayWithXElementsGreaterThanOrEqualX {
    public int specialArray(int[] nums) {
        int max = -1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        for (int i = 1; i <= max; i++) {
            int c = 0;
            for (int j = 0; j < nums.length; j++){
                if (nums[j] >= i) {
                    c++;
                }
            }
            if (c == i) {
                return i;
            }
        }
        return -1;
    }
}
