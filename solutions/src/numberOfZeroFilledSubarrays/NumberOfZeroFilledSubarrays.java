package numberOfZeroFilledSubarrays;

public class NumberOfZeroFilledSubarrays {
    public long zeroFilledSubarray(int[] nums) {
        int count = 0;
        long sum = 0;
        for (int num : nums) {
            if (num == 0) {
                count++;
            } else {
                while (count > 0) {
                    sum += count;
                    count--;
                }
            }
        }

        while (count > 0) {
            sum += count;
            count--;
        }

        return sum;
    }
}
