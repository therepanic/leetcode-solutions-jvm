package slidingSubarrayBeauty;

public class SlidingSubarrayBeauty {
    public static int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] answer = new int[nums.length - k + 1];
        int it = 0;
        int[] freq = new int[51];
        int l = 0;
        for (int r = 0; r < nums.length; r++) {
            if (nums[r] < 0) {
                freq[-nums[r]]++;
            }
            if (r - l + 1 > k) {
                if (nums[l] < 0) {
                    freq[-nums[l]]--;
                }
                l++;
            }
            if (r - l + 1 == k) {
                int count = 0;
                boolean already = false;
                for (int i = freq.length - 1; i >= 0; i--) {
                    if (freq[i] + count < x) {
                        count += freq[i];
                    } else {
                        count = x;
                    }
                    if (count == x) {
                        answer[it] = -i;
                        it++;
                        already = true;
                        break;
                    }
                }
                if (!already) {
                    it++;
                }
            }
        }
        return answer;
    }
}
