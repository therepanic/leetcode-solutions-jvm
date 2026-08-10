package consecutiveCharacters;

public class ConsecutiveCharacters {
    public int maxPower(String s) {
        char prev = ' ';
        int c = 1;
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (prev != s.charAt(i)) {
                max = Math.max(c, max);
                c = 1;
                prev = ch;
            } else {
                c++;
            }
        }
        return Math.max(c, max);
    }
}
