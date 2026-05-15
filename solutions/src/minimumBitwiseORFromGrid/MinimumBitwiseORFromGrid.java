package minimumBitwiseORFromGrid;

public class MinimumBitwiseORFromGrid {
    public int minimumOR(int[][] grid) {
        int ans = 0;
        for (int i = 31; i >= 0; i--) {
            int b = 1 << i;
            int mask = ans | (b - 1);
            for (int[] a1 : grid) {
                boolean bad = true;
                for (int a2 : a1) {
                    if ((a2 & mask) == a2) {
                        bad = false;
                        break;
                    }
                }
                if (bad) {
                    ans |= b;
                    break;
                }
            }
        }
        return ans;
    }
}
