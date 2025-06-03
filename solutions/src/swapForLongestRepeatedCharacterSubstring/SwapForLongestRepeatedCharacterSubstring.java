package swapForLongestRepeatedCharacterSubstring;

public class SwapForLongestRepeatedCharacterSubstring {

    public static int maxRepOpt1(String text) {
        int answer = 0;
        char[] textChars = text.toCharArray();
        int[] freq = new int[26];
        for (char c : textChars) {
            freq[c - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            char ch = (char) (i + 'a');
            int gap = 0;
            int l = 0;
            for (int r = 0; r < textChars.length; r++) {
                if (textChars[r] != ch) {
                    gap++;
                    while (gap > 1) {
                        if (textChars[l] != ch) {
                            gap--;
                        }
                        l++;
                    }
                }
                if (gap == 1) {
                    int windowSize = r - l + 1;
                    if (windowSize - 1 < freq[ch - 'a']) {
                        answer = Math.max(answer, windowSize);
                    } else {
                        answer = Math.max(answer, windowSize - 1);
                    }
                } else {
                    int windowSize = r - l + 1;
                    if (windowSize != freq[ch - 'a']) {
                        answer = Math.max(answer, windowSize + 1);
                    } else {
                        answer = Math.max(answer, windowSize);
                    }
                }
            }
        }
        return answer;
    }

}
