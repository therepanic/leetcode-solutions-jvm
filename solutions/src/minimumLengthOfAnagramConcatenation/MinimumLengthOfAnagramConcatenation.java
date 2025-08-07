package minimumLengthOfAnagramConcatenation;

public class MinimumLengthOfAnagramConcatenation {
    public int minAnagramLength(char[] sChars, int k) {
        int[] con1 = new int[26];
        for (int i = 0; i < k; i++) {
            con1[sChars[i] - 'a']++;
        }
        for (int i = k; i < sChars.length; i += k) {
            int[] con2 = new int[26];
            for (int j = i; j < i + k; j++) {
                con2[sChars[j] - 'a']++;
            }
            for (int j = 0; j < con2.length; j++) {
                if (con1[j] != con2[j]) return Integer.MAX_VALUE;
            }
        }
        return k;
    }

    public int minAnagramLength(String s) {
        char[] sChars = s.toCharArray();
        int minSize = s.length();
        for (int i = 1; i <= s.length(); i++) {
            if (s.length() % i == 0) {
                minSize = Math.min(minSize, minAnagramLength(sChars, i));
            }
        }
        return minSize;
    }
}
