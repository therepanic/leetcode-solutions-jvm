package intersectionOfTwoArraysII;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IntersectionOfTwoArraysII {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int onePointer = 0;
        int twoPointer = 0;

        List<Integer> intersection = new LinkedList<>();

        while (onePointer < nums1.length && twoPointer < nums2.length) {
            if (nums1[onePointer] > nums2[twoPointer]) {
                twoPointer++;
            } else if (nums1[onePointer] < nums2[twoPointer]) {
                onePointer++;
            } else {
                intersection.add(nums1[onePointer]);

                onePointer++;
                twoPointer++;
            }
        }

        int[] intersectionArray = new int[intersection.size()];

        for (int i = 0; i < intersection.size(); i++) {
            intersectionArray[i] = intersection.get(i);
        }

        return intersectionArray;
    }
}
