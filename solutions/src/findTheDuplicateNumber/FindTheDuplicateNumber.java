package findTheDuplicateNumber;

public class FindTheDuplicateNumber {
    public static int findDuplicate(int[] nums) {
        int firstPointer = nums[0];
        int secPointer = nums[0];

        do {
            firstPointer = nums[firstPointer];
            secPointer = nums[nums[secPointer]];

        } while (nums[firstPointer] != nums[secPointer]);

        secPointer = nums[0];

        while (firstPointer != secPointer) {
            firstPointer = nums[firstPointer];
            secPointer = nums[secPointer];
        }

        return firstPointer;
    }
}
