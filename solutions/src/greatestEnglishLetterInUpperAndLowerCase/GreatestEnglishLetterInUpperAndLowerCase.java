package greatestEnglishLetterInUpperAndLowerCase;

public class GreatestEnglishLetterInUpperAndLowerCase {
    public String greatestLetter(String s) {
        boolean[] yeah = new boolean[26];
        boolean[] no = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isLowerCase(ch)) {
                no[Character.toLowerCase(ch) - 'a'] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isUpperCase(ch) && no[Character.toLowerCase(ch) - 'a']) {
                yeah[Character.toLowerCase(ch) - 'a'] = true;
            }
        }
        for (int i = yeah.length - 1; i >= 0; i--) {
            if (yeah[i]) {
                return Character.toUpperCase((char) (i + 'a')) + "";
            }
        }
        return "";
    }
}
