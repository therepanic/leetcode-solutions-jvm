package houseRobberV;

public class HouseRobberV {
    public long rob(int[] nums, int[] colors) {
        long ans = 0;
        int i = 0;
        while (i < nums.length) {
            int j = i;
            while (j + 1 < nums.length && colors[j + 1] == colors[i]) {
                j++;
            }
            long skip = 0;
            long take = 0;
            for (int k = i; k <= j; k++) {
                long newTake = skip + nums[k];
                long newSkip = Math.max(skip, take);
                take = newTake;
                skip = newSkip;
            }
            ans += Math.max(skip, take);
            i = j + 1;
        }
        return ans;
    }
}
