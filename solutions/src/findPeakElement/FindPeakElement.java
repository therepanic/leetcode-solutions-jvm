package findPeakElement;

public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int l = 0;
        int r = nums.length - 1;

        while (l <= r) {
            int mid = (r - l) / 2 + l;

            int left = Integer.MIN_VALUE;
            int right = Integer.MIN_VALUE;

            if (mid + 1 < nums.length) {
                left = nums[mid + 1];
            }

            if (mid - 1 >= 0) {
                right = nums[mid - 1];
            }

            if (nums[mid] > left && nums[mid] > right) {
                return mid;
            } else if (nums[mid] < left) {
                l = mid + 1;
            } else if (nums[mid] < right) {
                r = mid - 1;
            } else {
                break;
            }
        }

        return 0;
    }
}
