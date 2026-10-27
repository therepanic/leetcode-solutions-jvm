package findTheKOrOfAnArray;

public class FindTheKOrOfAnArray {
    public int findKOr(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            int a = 0;
            for (int j = 0; j < nums.length && a < k; j++) {
                if ((nums[j] & (1 << i)) != 0) {
                    a++;
                }
            }
            if (a == k) {
                ans |= (1 << i);
            }
        }
        return ans;
    }
}
