package minimumAverageDifference;

public class MinimumAverageDifference {
    public static int minimumAverageDifference(int[] nums) {
        long[] left = new long[nums.length];
        long[] right = new long[nums.length];

        long sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            left[i] = sum / (i + 1);
        }

        sum = 0;

        for (int i = right.length - 1; i >= 0; i--) {
            sum += nums[i];

            right[i] = (long) (double) sum / (right.length - i);
        }


        int min = Integer.MAX_VALUE;
        long val = Integer.MAX_VALUE;;
        for (int i = 0; i < nums.length; i++) {
            long sumd = left[i];

            if (i != nums.length - 1) {
                sumd = Math.abs(sumd - right[i + 1]);
            }

            if (sumd < val) {
                val = sumd;
                min = i;
            }
        }

        return min;
    }
}
