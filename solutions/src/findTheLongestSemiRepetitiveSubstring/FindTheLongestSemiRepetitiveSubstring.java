package findTheLongestSemiRepetitiveSubstring;

public class FindTheLongestSemiRepetitiveSubstring {

    public static int longestSemiRepetitiveSubstring(String s) {
        char[] sChars = s.toCharArray();
        int l = 0;
        int answer = 1;
        int repetitive = 0;
        for (int r = 1; r < sChars.length; r++) {
            if (sChars[r] == sChars[r - 1]) {
                repetitive++;
            }
            while (repetitive > 1) {
                l++;
                if (sChars[l] == sChars[l - 1]) {
                    repetitive--;
                }
            }
            answer = Math.max(answer, r - l + 1);
        }
        return answer;
    }

}
