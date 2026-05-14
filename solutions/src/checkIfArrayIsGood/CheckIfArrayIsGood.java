package checkIfArrayIsGood;

public class CheckIfArrayIsGood {
    public boolean isGood(int[] nums) {
        int[] count = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 1 || nums[i] > nums.length - 1) {
                return false;
            }
            count[nums[i] - 1]++;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            if (count[i] != 1) {
                return false;
            }
        }
        return count[nums.length - 2] == 2;
    }
}
