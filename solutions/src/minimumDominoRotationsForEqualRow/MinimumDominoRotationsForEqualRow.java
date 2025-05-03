package minimumDominoRotationsForEqualRow;

public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] tops, int[] bottoms) {
       int ans = Math.min(check(tops[0], tops, bottoms), check(bottoms[0], tops, bottoms));
       return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    private int check(int start, int[] top, int[] bot) {
        int t = 0;
        int s = 0;
        for (int i = 0; i < top.length; i++) {
            if (top[i] != start && bot[i] != start) {
                return Integer.MAX_VALUE;
            } else if (top[i] != start) {
                t++;
            } else if (bot[i] != start) {
                s++;
            }
        }
        return Math.min(t, s);
    }
}
