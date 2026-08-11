package findCommonElementsBetweenTwoArrays;

public class FindCommonElementsBetweenTwoArrays {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        boolean[] val1 = new boolean[101];
        boolean[] val2 = new boolean[101];
        for (int v : nums1) {
            val1[v] = true;
        }
        int[] ans = new int[2];
        for (int v : nums2) {
            if (val1[v]) {
                ans[1]++;
            }
            val2[v] = true;
        }
        for (int v : nums1) {
            if (val2[v]) {
                ans[0]++;
            }
        }
        return ans;
    }
}
