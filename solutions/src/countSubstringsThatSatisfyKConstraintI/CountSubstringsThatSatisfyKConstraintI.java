package countSubstringsThatSatisfyKConstraintI;

public class CountSubstringsThatSatisfyKConstraintI {
    public int countKConstraintSubstrings(String s, int k) {
        char[] chars = s.toCharArray();
        int ones = 0;
        int zero = 0;
        int c = 0;
        int l = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '1') {
                ones++;
            } else {
                zero++;
            }
            while (ones > k && zero > k) {
                if (chars[l] == '1') {
                    ones--;
                } else {
                    zero--;
                }
                l++;
            }
            c += i - l + 1;
        }
        return c;
    }
}
