package randomPickWithWeight;

import java.util.Arrays;
import java.util.Random;

public class Solution {

    private int range;
    private final int[] ranges;
    private final Random random;

    public Solution(int[] w) {
        this.ranges = new int[w.length];
        for (int i = 0; i < this.ranges.length; i++) {
            this.range += w[i];
            this.ranges[i] += this.range - 1;
        }
        this.random = new Random();
    }

    public int pickIndex() {
        int ran = Arrays.binarySearch(ranges, this.random.nextInt(range));
        return ran >= 0 ? ran : -ran - 1;
    }

}
