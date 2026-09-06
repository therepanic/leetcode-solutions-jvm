class Solution {
    public int countRotations(String s, int k) {
        char[] chars = s.toCharArray();
        int c = 0;
        for (int i = 0; i < chars.length - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                c++;
            }
        }
        if (chars[0] == chars[chars.length - 1]) {
            c++;
        }
        if (c == k) {
            return s.length() - c;
        } else if (c - 1 == k) {
            return c;
        }
        return 0;
    }
}
