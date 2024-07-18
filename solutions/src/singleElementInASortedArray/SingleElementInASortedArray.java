package singleElementInASortedArray;

public class SingleElementInASortedArray {
    public static int singleNonDuplicate(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (true) {
            int mid = l + (r - l) / 2;

            if (mid >= 1 && nums[mid] == nums[mid - 1]) {
                if ((mid - 2 - l + 1) % 2 != 0) {
                    r = mid - 2;
                } else if ((r - mid + 2) % 2 != 0) {
                    l = mid + 1;
                }
            } else if (mid < nums.length - 1 && nums[mid] == nums[mid + 1]) {
                if ((mid - 1 - l + 1) % 2 != 0) {
                    r = mid - 1;
                } else if ((r - mid + 2 + 1) % 2 != 0) {
                    l = mid + 2;
                }
            } else {
                return nums[mid];
            }
        }
    }

}
