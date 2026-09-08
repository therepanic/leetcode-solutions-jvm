class Solution {
    public String maximumOddBinaryNumber(String s) {
        int ones = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }
        StringBuilder sb = new StringBuilder(s);
        sb.setCharAt(sb.length() - 1, '1');
        ones--;
        int it;
        for (it = 0; it < sb.length() && ones > 0; it++) {
            sb.setCharAt(it, '1');
            ones--;
        }
        for (int i = it; i < s.length() - 1; i++) {
            sb.setCharAt(i, '0');
        }
        return sb.toString();
    }
}
