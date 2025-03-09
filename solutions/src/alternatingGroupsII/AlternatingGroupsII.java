package alternatingGroupsII;

public class AlternatingGroupsII {
    public int numberOfAlternatingGroups(int[] colors, int k) {
        int l = 0;
        int c = 0;
        for (int r = 1; r <= colors.length + k - 2; r++) {
            int prev = (r - 1) % colors.length;
            int cur = r % colors.length;
            if (colors[cur] == colors[prev]) {
                l = r;
            }
            if (r - l + 1 >= k) {
                c++;
            }
        }
        return c;
    }
}
