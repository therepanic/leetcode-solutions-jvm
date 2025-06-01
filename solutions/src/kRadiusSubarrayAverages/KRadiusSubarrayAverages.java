package kRadiusSubarrayAverages;

import java.util.Arrays;

public class KRadiusSubarrayAverages {

    public int[] getAverages(int[] nums, int k) {
        int windowSize = k * 2 + 1;
        int l = 0;
        long sum  = 0;
        int[] answer = new int[nums.length];
        Arrays.fill(answer, -1);
        for (int r = 0; r < nums.length; r++) {
            sum += nums[r];
            if (r - l + 1 > windowSize) {
                sum -= nums[l];
                l++;
            }
            if (r - l + 1 == windowSize) {
                answer[r - k] = (int) Math.floor((double) sum / windowSize);
            }
        }
        return answer;
    }

}
