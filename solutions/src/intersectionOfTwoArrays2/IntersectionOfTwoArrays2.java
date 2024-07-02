package intersectionOfTwoArrays2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntersectionOfTwoArrays2 {
    public static int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> intersectedList = new ArrayList<>();

        int oneNumPointer = 0;
        int twoNumPointer = 0;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        while (oneNumPointer < nums1.length && twoNumPointer < nums2.length) {
            if (nums1[oneNumPointer] > nums2[twoNumPointer]) {
                twoNumPointer++;
            } else if (nums1[oneNumPointer] < nums2[twoNumPointer]) {
                oneNumPointer++;
            } else {
                intersectedList.add(nums1[oneNumPointer]);

                oneNumPointer++;
                twoNumPointer++;
            }
        }

        int[] intersected = new int[intersectedList.size()];

        for (int i = 0; i < intersectedList.size(); i++) {
            intersected[i] = intersectedList.get(i);
        }

        return intersected;
    }
}
