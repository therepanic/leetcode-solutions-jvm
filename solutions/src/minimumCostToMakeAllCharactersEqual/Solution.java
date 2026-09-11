class Solution {
    public long minimumCost(String s) {
        long ans = 0;
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] != chars[i - 1]) {
                ans += Math.min(i, chars.length - i);
            }
        }
        return ans;
    }
}
