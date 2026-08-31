class Solution {
    public long minInitialStrength(int[] monsters, int[][] boosts) {
      int n = monsters.length;
      long[] diff = new long[n];
      for (int[] boost : boosts) {
        int l = boost[0];
        int r = boost[1];
        int v = boost[2];
        diff[l] += v;
        if (r + 1 < n) {
          diff[r + 1] -= v;
        }
      }
      long cur = 0;
      long[] total = new long[n];
      for (int i = 0; i < n; i++) {
        cur += diff[i];
        total[i] = cur;
      }
      long ans = 0;
      for (int i = n - 1; i >= 0; i--) {
        if (ans > 0) {
          ans += monsters[i];  
        } else {
          ans += Math.max(monsters[i] - total[i], 0);
        }
      }
      return ans;
    }
}
