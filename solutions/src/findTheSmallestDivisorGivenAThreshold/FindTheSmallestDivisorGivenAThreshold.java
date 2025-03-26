package findTheSmallestDivisorGivenAThreshold;

import java.util.Arrays;

public class FindTheSmallestDivisorGivenAThreshold {
    public static int smallestDivisor(int[] nums, int threshold) {
        int l = 1;
        int r = Arrays.stream(nums).max().getAsInt();
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int sum = 0;
            for (int num : nums) {
                sum += (num + mid - 1) / mid;
            }
            if (sum > threshold) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}
