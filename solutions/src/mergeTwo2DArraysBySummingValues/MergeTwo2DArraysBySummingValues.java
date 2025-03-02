package mergeTwo2DArraysBySummingValues;

import java.util.Arrays;

public class MergeTwo2DArraysBySummingValues {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        int i = 0, j = 0, k = 0;
        int[][] result = new int[nums1.length + nums2.length][2];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i][0] < nums2[j][0]) {
                result[k++] = nums1[i++];
            } else if (nums1[i][0] > nums2[j][0]) {
                result[k++] = nums2[j++];
            } else {
                result[k][0] = nums1[i][0];
                result[k][1] = nums1[i][1] + nums2[j][1];
                k++;
                i++;
                j++;
            }
        }
        while (i < nums1.length) result[k++] = nums1[i++];
        while (j < nums2.length) result[k++] = nums2[j++];
        return Arrays.copyOf(result, k);
    }
}
