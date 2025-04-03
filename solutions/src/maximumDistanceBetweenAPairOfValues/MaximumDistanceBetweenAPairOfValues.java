package maximumDistanceBetweenAPairOfValues;

public class MaximumDistanceBetweenAPairOfValues {
    public static int maxDistance(int[] nums1, int[] nums2) {
        int i = 0, j = 0, maxDistance = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                maxDistance = Math.max(maxDistance, j - i);
                j++;
            } else {
                i++;
                if (i > j) {
                    j = i;
                }
            }
        }
        return maxDistance;
    }
}
