package minimumOperationsToTransformArray;

public class MinimumOperationsToTransformArray {
    public long minOperations(int[] nums1, int[] nums2) {
        long c = 0;
        for (int i = 0; i < nums1.length; i++) {
            c += Math.abs(nums1[i] - nums2[i]);
        }
        long v = Long.MAX_VALUE;
        long first = nums2[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            long lowest = Math.min(nums1[i], nums2[i]);
            long max = Math.max(nums1[i], nums2[i]);
            long d = 0;
            if (first < lowest) {
                d = lowest - first;
            } else if (first > max) {
                d = first - max;
            }
            v = Math.min(d, v);
        }
        return c + v + 1;
    }
}
