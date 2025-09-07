package findNUniqueIntegersSumUpToZero;

public class FindNUniqueIntegersSumUpToZero {
    public int[] sumZero(int n) {
        int nCopy = n;
        int nPol = n / 2;
        if (nPol * 2 != n) {
            n--;
            nPol = n / 2;
        }
        int[] ans = new int[nCopy];
        int c = 1;
        for (int i = 0; i < n; i++) {
            if (i < nPol) {
                ans[i] = c;
                c++;
            } else {
                if (c > 0) {
                    c = -1;
                }
                ans[i] = c;
                c--;
            }
        }
        return ans;
    }
}
