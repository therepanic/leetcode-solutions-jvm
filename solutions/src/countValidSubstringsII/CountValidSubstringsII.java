package countValidSubstringsII;

public class CountValidSubstringsII {
    public long countValidSubstrings(String s) {
        long count = 0;
        int a = -1, b = -1, c = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a') {
                a = i;
            } else if (ch == 'b') {
                b = a;
            } else if (ch == 'c') {
                c = b;
            }
            count += i - c;
        }
        return count;
    }
}
