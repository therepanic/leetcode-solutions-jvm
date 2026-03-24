package constructUniformParityArrayII;

public class ConstructUniformParityArrayII {
    public boolean uniformArray(int[] nums1) {
        boolean odd = false;
        int minOdd = Integer.MAX_VALUE;
        int n = nums1.length;
        for (int i = 0; i < n; i++) {
            if (nums1[i] % 2 == 1) {
                odd = true;
                minOdd = Math.min(minOdd, nums1[i]);
            }
        }
        if (!odd) {
            return true;
        }
        for (int i = 0; i < n; i++) {
            if (nums1[i] % 2 == 0 && minOdd > nums1[i]) {
                return false;
            }
        }
        return true;
    }
}
