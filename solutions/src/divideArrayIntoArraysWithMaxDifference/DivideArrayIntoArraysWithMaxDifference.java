package divideArrayIntoArraysWithMaxDifference;

import java.util.Arrays;

public class DivideArrayIntoArraysWithMaxDifference {

    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int[][] answer = new int[nums.length / 3][3];
        int it = 0;
        int c = 0;
        for (int i = 0; i < nums.length; i++) {
            answer[it][i % 3] = nums[i];
            if (answer[it][i % 3] - answer[it][0] > k) {
                return new int[0][0];
            }
            if (c == 2) {
                it++;
                c = 0;
            } else {
                c++;
            }
        }
        return answer;
    }

}
