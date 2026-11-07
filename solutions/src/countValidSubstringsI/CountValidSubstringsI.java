package countValidSubstringsI;

public class CountValidSubstringsI {
    public long countValidSubstrings(String s) {
        long count = 0;
        char[] chars = s.toCharArray();
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i >= 2 && chars[i - 2] == 'a' && chars[i - 1] == 'b' && chars[i] == 'c') {
                count += 2;
                l = i - 1;
            } else {
                int a = i - l + 1;
                count += a;
            }
        }
        return count;
    }
}
