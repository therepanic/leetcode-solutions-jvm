package waysToMakeAFairArray;

public class WaysToMakeAFairArray {
    public int waysToMakeFair(int[] nums) {
        int odd = 0;
        int even = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                even += nums[i];
            } else {
                odd += nums[i];
            }
        }
        int curOdd = 0;
        int curEven = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                even -= nums[i];
            } else {
                odd -= nums[i];
            }
            if (curEven + odd == even + curOdd) count++;
            if (i % 2 == 0) {
                curEven += nums[i];
            } else {
                curOdd += nums[i];
            }
        }

        return count;
    }
}
