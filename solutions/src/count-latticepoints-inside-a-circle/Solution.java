class Solution {
    public int countLatticePoints(int[][] circles) {
        int ans = 0;
        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= 200; j++) {
                for (int[] v : circles) {
                    int a = v[0] - i;
                    int b = v[1] - j;
                    if (a * a + b * b <= v[2] * v[2]) {
                        ans++;
                        break;
                    }
                }
            }
        }
        return ans;
    }
}
