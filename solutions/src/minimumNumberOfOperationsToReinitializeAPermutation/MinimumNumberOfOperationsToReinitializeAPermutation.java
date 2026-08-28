package minimumNumberOfOperationsToReinitializeAPermutation;

public class MinimumNumberOfOperationsToReinitializeAPermutation {
    public int reinitializePermutation(int n) {
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = i;
        }
        int c = 0;
        do {
            op(ans);
            c++;
            boolean ok = true;
            for (int i = 0; i < n; i++) {
                if (ans[i] != i) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                return c;
            }
        } while (true);
    }

    public void op(int[] ans) {
        int[] next = new int[ans.length];
        for (int i = 0; i < ans.length; i++) {
            if (i % 2 == 0) {
                next[i] = ans[i / 2];
            } else {
                next[i] = ans[ans.length / 2 + (i - 1) / 2];
            }
        }
        System.arraycopy(next, 0, ans, 0, ans.length);
    }

}
