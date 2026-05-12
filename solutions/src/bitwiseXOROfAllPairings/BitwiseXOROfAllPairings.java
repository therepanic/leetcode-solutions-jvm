package bitwiseXOROfAllPairings;

public class BitwiseXOROfAllPairings {
    public int xorAllNums(int[] nums1, int[] nums2) {
        boolean firstEven = nums1.length % 2 == 0;
        boolean secondEven = nums2.length % 2 == 0;
        if (firstEven && secondEven) return 0;
        if (firstEven) {
            return xorAllNums(nums1, nums2, firstEven, secondEven);
        } else {
            return xorAllNums(nums2, nums1, secondEven, firstEven);
        }
    }

    public int xorAllNums(int[] nums1, int[] nums2, boolean firstEven, boolean secondEven) {
        int a = 0;
        for (int i = 0; i < nums1.length; i++) {
            a ^= nums1[i];
        }if (!firstEven && !secondEven) {
            for (int i = 0; i < nums2.length; i++) {
                a ^= nums2[i];
            }
        }
        return a;
    }
}
