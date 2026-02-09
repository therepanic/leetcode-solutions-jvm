package shuffleTheArray;

public class ShuffleTheArray {
    public int[] shuffle(int[] nums, int n) {
        int[] ngl = new int[2 * n];
        int it = 0;
        for (int i = 0; i < 2 * n; i += 2, it++) {
            ngl[i] = nums[it];
            ngl[i + 1] = nums[n + it];
        }
        return ngl;
    }
}
