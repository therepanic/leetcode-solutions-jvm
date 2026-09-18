package maximumLengthOfSubarrayWithPositiveProduct;

public class MaximumLengthOfSubarrayWithPositiveProduct {
    public int getMaxLen(int[] nums) {
        int l = 0;
        int answer = 0;
        int neg = 0;
        int s = -1;
        int e = -1;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] == 0) {
                if (neg % 2 == 0) {
                    answer = Math.max(answer, r - l);
                } else {
                    answer = Math.max(e - l, Math.max(answer, r - s - 1));
                }
                neg = 0;
                s = -1;
                e = -1;
                l = r + 1;
            } else {
                if (nums[r] < 0) {
                    neg++;
                    if (s == -1) {
                        s = r;
                    }
                    e = r;
                }
            }
        }
        if (neg % 2 == 0) {
            answer = Math.max(answer, nums.length - l);
        } else {
            answer = Math.max(e - l, Math.max(answer, nums.length - s - 1));
        }
        return answer;
    }
}
