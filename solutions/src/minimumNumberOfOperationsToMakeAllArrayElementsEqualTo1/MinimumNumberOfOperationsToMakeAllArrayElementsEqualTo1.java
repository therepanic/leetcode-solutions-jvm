package minimumNumberOfOperationsToMakeAllArrayElementsEqualTo1;

import java.util.Arrays;

public class MinimumNumberOfOperationsToMakeAllArrayElementsEqualTo1 {

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static int gcdArray(int[] arr) {
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result = gcd(result, arr[i]);
        }
        return result;
    }

    public static int minOperations(int[] nums) {
        int ones = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                ones++;
            }
        }
        if (ones > 0) {
            return nums.length - ones;
        }
        for (int i = 2; i <= nums.length; i++) {
            int l = 0;
            for (int r = 0; r < nums.length; r++) {
                if (r - l + 1 > i) {
                    l++;
                }
                int[] a = Arrays.copyOfRange(nums, l, r + 1);
                int g = gcdArray(a);
                if (g == 1) {
                    return (a.length - 1) + (nums.length - 1);
                }
            }
        }
        return -1;
    }
}
