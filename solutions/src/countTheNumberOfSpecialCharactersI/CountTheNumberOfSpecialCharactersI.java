package countTheNumberOfSpecialCharactersI;

public class CountTheNumberOfSpecialCharactersI {
    public int numberOfSpecialChars(String word) {
        int c = 0;
        int[] lower = new int[26];
        int[] higher = new int[26];
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (Character.isLowerCase(ch)) {
                lower[ch - 'a']++;
                if (lower[ch - 'a'] == 1 && higher[ch - 'a'] > 0) {
                    c++;
                }
            } else {
                char a = Character.toLowerCase(ch);
                higher[a - 'a']++;
                if (higher[a - 'a'] == 1 && lower[a - 'a'] > 0) {
                    c++;
                }
            }
        }
        return c;
    }
}
