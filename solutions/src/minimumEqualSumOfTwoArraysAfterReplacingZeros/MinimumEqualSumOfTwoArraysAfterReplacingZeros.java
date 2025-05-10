package minimumEqualSumOfTwoArraysAfterReplacingZeros;

public class MinimumEqualSumOfTwoArraysAfterReplacingZeros {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        long sum2 = 0;
        int zero1Count = 0;
        int zero2Count = 0;
        for (int i = 0; i < nums1.length; i++) {
            sum1 += nums1[i];
            if (nums1[i] == 0) {
                zero1Count++;
                sum1++;
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            sum2 += nums2[i];
            if (nums2[i] == 0) {
                zero2Count++;
                sum2++;
            }
        }
        if (zero1Count == 0 && sum2 > sum1 || zero2Count == 0 && sum1 > sum2) {
            return -1;
        }
        return Math.max(sum2, sum1);
    }
}
