package movingZeroes;

import java.util.ArrayDeque;
import java.util.Queue;

public class MovingZeroes {
    public static void moveZeroes(int[] nums) {
        Queue<Integer> queueZeroIndex = new ArrayDeque<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                queueZeroIndex.add(i);
            } else if (!queueZeroIndex.isEmpty()){
                nums[queueZeroIndex.poll()] = nums[i];
                nums[i] = 0;
                queueZeroIndex.add(i);
            }
        }
    }
}
