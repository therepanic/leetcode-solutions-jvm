package findTheScoreDifferenceInAGame;

public class FindTheScoreDifferenceInAGame {
    public int scoreDifference(int[] nums) {
        int sum = 0;
        boolean role = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 != 0) {
                role = !role;
            }
            if (i % 6 == 5) {
                role = !role;
            }
            if (!role) {
                sum += nums[i];
            } else {
                sum -= nums[i];
            }
        }
        return sum;
    }
}
