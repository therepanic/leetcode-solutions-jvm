package validSubarraysWithMatchingSumDigits;

public class ValidSubarraysWithMatchingSumDigits {
    public int countValidSubarrays(int[] nums, int x) {
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            long sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                long num = sum;
                long last = sum % 10;
                long first = 0;
                while (num > 0) {
                    first = num;
                    num /= 10;
                }
                if (first == x && last == x) {
                    c++;
                }
            }
        }
        return c;
    }
}
