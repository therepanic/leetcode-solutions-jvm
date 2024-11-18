package removeDuplicatesFromSortedArrayII;

public class RemoveDuplicatesFromSortedArrayII {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int writeIndex = 2;

        for (int readIndex = 2; readIndex < nums.length; readIndex++) {
            if (nums[readIndex] != nums[writeIndex - 2]) {
                nums[writeIndex] = nums[readIndex];

                writeIndex++;
            }
        }

        return writeIndex;
    }
}
