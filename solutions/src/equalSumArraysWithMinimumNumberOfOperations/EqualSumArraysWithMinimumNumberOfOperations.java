package equalSumArraysWithMinimumNumberOfOperations;

public class EqualSumArraysWithMinimumNumberOfOperations {
    public static int minOperations(int[] nums1, int[] nums2) {
        int sum1 = 0, sum2 = 0;
        for (int i = 0; i < nums1.length; i++) {
            sum1 += nums1[i];
        }
        for (int i = 0; i < nums2.length; i++) {
            sum2 += nums2[i];
        }
        if (sum1 == sum2) return 0;
        int needed = Math.abs(sum1 - sum2);
        int[] count = new int[6];
        if (sum1 > sum2) {
            for (int i = 0; i < nums2.length; i++) {
                count[6 - nums2[i]]++;
            }
            for (int i = 0; i < nums1.length; i++) {
                count[nums1[i] - 1]++;
            }
        } else {
            for (int i = 0; i < nums1.length; i++) {
                count[6 - nums1[i]]++;
            }
            for (int i = 0; i < nums2.length; i++) {
                count[nums2[i] - 1]++;
            }
        }
        int operations = 0;
        for (int i = 5; i >= 1; i--) {
            while (count[i] > 0) {
                operations++;
                needed -= i;
                if (needed <= 0) {
                    return operations;
                }
                count[i]--;
            }
        }
        return needed <= 0 ? operations : -1;
    }
}
