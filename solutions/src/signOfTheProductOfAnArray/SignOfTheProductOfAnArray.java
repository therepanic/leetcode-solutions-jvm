package signOfTheProductOfAnArray;

public class SignOfTheProductOfAnArray {
    public int arraySign(int[] nums) {
        int min = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                return 0;
            } else if (nums[i] < 0) {
                min++;
            }
        }
        return min % 2 != 0 ? -1 : 1;
    }
}
