package arithmeticSlices;

public class ArithmeticSlices {
    public int numberOfArithmeticSlices(int[] nums) {
        int groupCount = 0;
        int arithmetic = Integer.MIN_VALUE;
        int items = 1;

        for (int i = 1; i < nums.length; i++) {
            if (arithmetic == Integer.MIN_VALUE || nums[i] - nums[i - 1] == arithmetic) {
                items++;
            } else {
                for (int j = items - 2; j > 0; j--) {
                    groupCount += j;
                }

                items = 2;
            }

            arithmetic = nums[i] - nums[i - 1];
        }

        if (items >= 3) {
            for (int j = items - 2; j > 0; j--) {
                groupCount += j;
            }
        }

        return groupCount;
    }
}
