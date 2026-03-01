package trimTrailingVowels;

public class TrimTrailingVowels {
    public String trimTrailingVowels(String s) {
        int it = s.length();
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch != 'a' && ch != 'e' && ch != 'i' && ch != 'o' && ch != 'u') {
                break;
            }
            it = i;
        }
        return s.substring(0, it);
    }
}
