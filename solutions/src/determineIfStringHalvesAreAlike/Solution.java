class Solution {
    public boolean halvesAreAlike(String s) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
                if (i < s.length() / 2) {
                    a++;
                } else {
                    b++;
                }
            }
        }
        return a == b;
    }
}
