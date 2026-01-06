package transformArrayoAllEqualElements;

public class TransformArrayToAllEqualElements {

    public boolean canMakeEqual(int[] nums, int k) {
        return make(nums.clone(), k, -1) || make(nums, k, 1);
    }

    public boolean make(int[] nums, int k, int to) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] != to) {
                nums[i] *= -1;
                nums[i + 1] *= -1;
                k--;
            }
            if (k == -1) {
                return false;
            }
        }
        return nums[nums.length - 1] == to;
    }

}
