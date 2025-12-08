package countSquareSumTriples;

public class CountSquareSumTriples {
    public int countTriples(int n) {
        int ans = 0;
        for (int a = 1; a <= n; a++) {
            for (int b = 1; b <= n; b++) {
                double prod = (double) a * a + b * b;
                int c = (int) Math.sqrt(prod);
                if (c <= n && c * c == prod) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
