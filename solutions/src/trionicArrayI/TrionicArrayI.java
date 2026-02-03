package trionicArrayI;

public class TrionicArrayI {
    public boolean isTrionic(int[] nums) {
        int i = 1;
        while (i < nums.length && nums[i - 1] < nums[i]) {
            i++;
        }
        int p = i - 1;
        while (i < nums.length && nums[i - 1] > nums[i]) {
            i++;
        }
        int q = i - 1;
        while (i < nums.length && nums[i - 1] < nums[i]) {
            i++;
        }
        int d = i - 1;
        return p != 0 && q != p && d != q && d == nums.length - 1;
    }
}
