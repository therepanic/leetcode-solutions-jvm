class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        List<Integer> arr = new ArrayList<>();
        int[] numbers = new int[101];
        for (int i = 0; i < nums.length; i++) {
            if (numbers[nums[i]] < k) {
                arr.add(nums[i]);
                numbers[nums[i]]++;
            }
        }
        int[] ans = new int[arr.size()];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = arr.get(i);
        }
        return ans;
    }
}
