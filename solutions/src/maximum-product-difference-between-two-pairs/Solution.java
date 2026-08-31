class Solution {
    public int maxProductDifference(int[] nums) {
      int a = 0;
      int b = 0;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] > a) {
          b = a;
          a = nums[i];
        } else if (nums[i] > b) {
          b = nums[i];
        }
      }
      int z = Integer.MAX_VALUE;
      int d = Integer.MAX_VALUE;
      for (int i = 0; i < nums.length; i++) {
        if (nums[i] < z) {
          d = z;
          z = nums[i];
        } else if (nums[i] < d) {
          d = nums[i];
        }
      }
    return (a * b) - (z * d);
    }
}
