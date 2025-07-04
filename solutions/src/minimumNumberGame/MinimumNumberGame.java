package minimumNumberGame;

import java.util.Arrays;

public class MinimumNumberGame {

    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int[] answer = new int[nums.length];
        for (int i = 1; i < nums.length; i += 2) {
            answer[i - 1] = nums[i];
            answer[i] = nums[i - 1];
        }
        return answer;
    }

}
