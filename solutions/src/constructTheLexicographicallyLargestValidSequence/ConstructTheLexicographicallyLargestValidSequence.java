package constructTheLexicographicallyLargestValidSequence;

public class ConstructTheLexicographicallyLargestValidSequence {
    public int[] constructDistancedSequence(int n) {
        int[] result = new int[2 * n - 1];
        boolean[] used = new boolean[n + 1];
        helper(result, used, 0, n);
        return result;
    }

    private boolean helper(int[] result, boolean[] used, int it, int n) {
        if (it == result.length) return true;
        if (result[it] != 0) {
            return helper(result, used, it + 1, n);
        }
        for (int i = n; i >= 1; i--) {
            if (used[i]) continue;
            if (i == 1) {
                result[it] = 1;
                used[1] = true;
                if (helper(result, used, it + 1, n)) return true;
                result[it] = 0;
                used[1] = false;

            } else {
                int secondIndex = i + it;
                if (secondIndex < result.length && result[secondIndex] == 0) {
                    result[it] = i;
                    result[secondIndex] = i;
                    used[i] = true;
                    if (helper(result, used, it + 1, n)) return true;
                    result[it] = 0;
                    result[secondIndex] = 0;
                    used[i] = false;
                }
            }
        }
        return false;
    }
}
