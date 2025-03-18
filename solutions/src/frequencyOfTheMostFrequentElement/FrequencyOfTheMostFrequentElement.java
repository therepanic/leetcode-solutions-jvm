package frequencyOfTheMostFrequentElement;

import java.util.Arrays;

public class FrequencyOfTheMostFrequentElement {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0;
        long point = 0;
        int max = 0;
        for (int r = 0; r < nums.length; r++) {
            point += nums[r];
            while ((long) (r - l + 1) * nums[r] - point > k) {
                point -= nums[l];
                l++;
            }
            max = Math.max(max, r - l + 1);
        }
        return max;
    }
}
