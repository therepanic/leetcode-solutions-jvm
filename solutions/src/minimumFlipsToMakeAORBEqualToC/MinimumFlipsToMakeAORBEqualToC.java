package minimumFlipsToMakeAORBEqualToC;

public class MinimumFlipsToMakeAORBEqualToC {
    public int minFlips(int a, int b, int c) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            boolean first = (a & (1 << i)) != 0;
            boolean second = (b & (1 << i)) != 0;
            boolean third = (c & (1 << i)) != 0;
            if (third) {
                if (!first && !second) {
                    ans++;
                }
            } else {
                if (first || second) {
                    if (first && second) {
                        ans += 2;
                    } else {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
