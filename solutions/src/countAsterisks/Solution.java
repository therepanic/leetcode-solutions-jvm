class Solution {
    public int countAsterisks(String s) {
        int ans = 0;
        int asterisks = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '*' && asterisks % 2 == 0) {
                ans++;
            } else if (ch == '|') {
                asterisks++;
            }
        }
        return ans;
    }
}
