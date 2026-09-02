class Solution {
    public int sumOfEncryptedInt(int[] nums) {
        int sum = 0;
        for (int v :nums) {
            int max = -1;
            char[] b = String.valueOf(v).toCharArray();
            for (char c : b) {
                int a = c - '0';
                max = Math.max(max, a);
            }
            int d = 0;
            for (int i = 0; i < b.length; i++) {
                d *= 10;
                d += max;
            }
            sum += d;
        }
        return sum;
    }
}
