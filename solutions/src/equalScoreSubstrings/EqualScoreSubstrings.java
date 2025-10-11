package equalScoreSubstrings;

public class EqualScoreSubstrings {
    public static boolean scoreBalance(String s) {
        int n = s.length();
        if (n < 2) return false;
        int total = 0;
        for (int i = 0; i < n; i++) {
            total += s.charAt(i) - 'a' + 1;
        }
        int left = 0;
        for (int i = 0; i < n - 1; i++) {
            left += s.charAt(i) - 'a' + 1;
            if (left == total - left) {
                return true;
            }
        }
        return false;
    }
}
