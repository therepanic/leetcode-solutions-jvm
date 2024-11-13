package maxConsecutiveOnesIII;

public class MaxConsecutiveOnesIII {
    public int longestOnes(int[] nums, int k) {
        int oneCount = 0;
        int zeroCount = 0;

        int l = 0;

        int answer = 0;

        for (int r = 0; r < nums.length; r++) {
            while (zeroCount > k) {
                if (nums[l] == 0) {
                    zeroCount--;
                } else {
                    oneCount--;
                }
                l++;
            }

            answer = Math.max(answer, oneCount + zeroCount);

            if (nums[r] == 0) {
                zeroCount++;
            } else if (nums[r] == 1) {
                oneCount++;
            }
        }

        if (zeroCount <= k) {
            answer = Math.max(answer, oneCount + zeroCount);
        }

        return answer;
    }
}
