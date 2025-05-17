package shuffleAnArray;

import java.util.Random;

public class Solution {

    private final int[] og;
    private int[] shuffled;
    private final Random random = new Random();

    public Solution(int[] nums) {
        this.og = nums;
        this.shuffled = nums.clone();
    }

    public int[] reset() {
        this.shuffled = og.clone();
        return this.shuffled;
    }

    public int[] shuffle() {
        for (int i = this.shuffled.length - 1; i > 0; i--) {
            int it = this.random.nextInt(i + 1);
            int buff = this.shuffled[it];
            this.shuffled[it] = this.shuffled[i];
            this.shuffled[i] = buff;
        }
        return shuffled;
    }

}
