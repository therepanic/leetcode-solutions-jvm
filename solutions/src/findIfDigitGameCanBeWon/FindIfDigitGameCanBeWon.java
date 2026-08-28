package findIfDigitGameCanBeWon;

public class FindIfDigitGameCanBeWon {
    public boolean canAliceWin(int[] nums) {
        int sum = 0;
        int single = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (nums[i] / 10 == 0) {
                single += nums[i];
            }
        }
        return single > sum - single || sum - single > single;
    }
}
