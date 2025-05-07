package minimumAdditionsToMakeValidString;

public class MinimumAdditionsToMakeValidString {
    public int addMinimum(String word) {
        char[] sChars = word.toCharArray();
        char lastChar = sChars[0];
        int answer = 0;
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] <= lastChar) {
                answer += 3;
            }
            lastChar = sChars[i];
        }
        return answer - word.length();
    }
}
