package sumOfAbsoluteDifferencesInASortedArray;

public class SumOfAbsoluteDifferencesInASortedArray {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            left[i] = nums[i] + (i != 0 ? left[i - 1] : 0);
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            right[i] = nums[i] + (i != nums.length - 1 ? right[i + 1] : 0);
        }

        int[] prefixes = new int[nums.length];

        for (int i = 0; i < prefixes.length; i++) {
            int l = 0;

            if (i > 0) {
                l += left[i - 1];
            }

            int r = 0;
            if (i < nums.length - 1) {
                r += right[i + 1];
            }

            prefixes[i] += r - ((prefixes.length - i - 1) * nums[i]);
            prefixes[i] += Math.abs(l - (i * nums[i]));
        }

        return prefixes;
    }
}
