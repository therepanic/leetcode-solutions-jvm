package reverseLettersThenSpecialCharactersInAString;

public class ReverseLettersThenSpecialCharactersInAString {
    public String reverseByType(String s) {
        int l = 0;
        int r = s.length() - 1;
        char[] sChars = s.toCharArray();
        while (l < r) {
            while (l < r && !Character.isLetter(sChars[l])) {
                l++;
            }
            while (l < r && !Character.isLetter(sChars[r])) {
                r--;
            }
            if (l < r) {
                char ch = sChars[l];
                sChars[l] = sChars[r];
                sChars[r] = ch;
            }
            l++;
            r--;
        }
        l = 0;
        r = s.length() - 1;
        while (l < r) {
            while (l < r && Character.isLetter(sChars[l])) {
                l++;
            }
            while (l < r && Character.isLetter(sChars[r])) {
                r--;
            }
            if (l < r) {
                char ch = sChars[l];
                sChars[l] = sChars[r];
                sChars[r] = ch;
            }
            l++;
            r--;
        }
        return new String(sChars);
    }
}
