package sumOfGCDOfFormedPairs;

import java.util.Arrays;

public class SumOfGCDOfFormedPairs {
    public long gcdSum(int[] nums) {
        int[] arr = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            arr[i] = gcd(max, nums[i]);
        }
        Arrays.sort(arr);
        long sum = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            sum += gcd(arr[i], arr[arr.length - i - 1]);
        }
        return sum;
    }

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }
}
