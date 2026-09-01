class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = tasks.length;
        int m = shifts.length;
        long[] prefix = new long[n];
        long s = 0;
        for (int i = 0; i < n; i++) {
            s += tasks[i];
            prefix[i] = s;
        }
        long d = 0;
        int[] ans = new int[m];
        for (int i = 0; i < m; i++) {
            if (d + shifts[i] >= s) {
                d = 0;
            } else {
                d += shifts[i];
                int l = 0;
                int r = n;
                while (l < r) {
                    int mid = l + (r - l) / 2;
                    if (prefix[mid] <= d) {
                        l = mid + 1;
                    } else {
                        r = mid;
                    }
                }
                ans[i] = n - l;
            }
        }
        return ans;
    }
}
