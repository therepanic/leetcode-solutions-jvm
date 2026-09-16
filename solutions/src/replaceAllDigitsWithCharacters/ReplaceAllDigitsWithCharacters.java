package replaceAllDigitsWithCharacters;

public class ReplaceAllDigitsWithCharacters {
    public String replaceDigits(String s) {
        StringBuilder ans = new StringBuilder();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (Character.isDigit(chars[i])) {
                int shift = chars[i] - '0';
                char ch = (char) ((((chars[i - 1] - 'a') + shift) % 26) + 'a');
                ans.append(ch);
            } else {
                ans.append(chars[i]);
            }
        }
        return ans.toString();
    }
}
