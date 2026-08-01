package countValidPrefixes;

public class CountValidPrefixes {
    public int countValidPrefixes(String s) {
        int zero = 0;
        int one = 0;
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - '0';
            if (num == 1) {
                one++;
            } else {
                zero++;
            }
            if (Math.abs(zero - one) == 1 || Math.abs(zero - one) == 0) {
                c++;
            }
        }
        return c;
    }
}
