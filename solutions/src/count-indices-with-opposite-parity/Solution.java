class Solution {
    public int[] countOppositeParity(int[] nums) {
        int[] odd = new int[nums.length];
        int[] even = new int[nums.length];
        odd[odd.length - 1] = nums[nums.length - 1] % 2 != 0 ? 1 : 0;
        even[even.length - 1] = nums[nums.length - 1] % 2 == 0 ? 1 : 0;
        for (int i = nums.length - 2; i >= 0; i--) {
            even[i] = nums[i] % 2 == 0 ? 1 : 0;
            odd[i] = nums[i] % 2 != 0 ? 1 : 0;
            even[i] += even[i + 1];
            odd[i] += odd[i + 1];
        }
        int[] ans = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            ans[i] = nums[i] % 2 == 0 ? odd[i] : even[i];
        }
        return ans;
    }
}
