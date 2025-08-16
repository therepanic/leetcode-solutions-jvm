package detectCapital;

public class DetectCapital {
    public boolean detectCapitalUse(String word) {
        int capital = 0;
        for (int i = 0; i < word.length(); i++) {
            capital += Character.isUpperCase(word.charAt(i)) ? 1 : 0;
        }
        return capital == 0 || capital == 1 && Character.isUpperCase(word.charAt(0)) || capital == word.length();
    }
}
