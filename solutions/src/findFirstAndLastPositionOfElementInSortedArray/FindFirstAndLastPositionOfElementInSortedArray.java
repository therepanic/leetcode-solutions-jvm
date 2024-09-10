package findFirstAndLastPositionOfElementInSortedArray;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static int[] searchRange(int[] nums, int target) {
        int middleIndex = search(nums, 0, nums.length - 1, target);

        if (middleIndex == -1) {
            return new int[] {-1, -1};
        }

        int leftIndex = findLeftSide(nums, middleIndex - 1, target);
        int rightIndex = findRightSide(nums, middleIndex + 1, nums.length - 1, target);

        return new int[] {leftIndex + 1, rightIndex - 1};
    }

    public static int findLeftSide(int[] nums, int i, int target) {
        int index = search(nums, 0, i, target);

        if (index != -1) {
            return findLeftSide(nums, index - 1, target);
        }

        return i;
    }

    public static int findRightSide(int[] nums, int start, int end, int target) {
        int index = search(nums, start, end, target);

        if (index != -1) {
            return findRightSide(nums, index + 1, end, target);
        }

        return start;
    }

    public static int search(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int middle = start + (end - start) / 2;

            if (nums[middle] > target) {
                end--;
            } else if (nums[middle] < target) {
                start++;
            } else {
                return middle;
            }
        }
        return -1;
    }
}
