package vowelConsonantScore;

public class VowelConsonantScore {
    public int vowelConsonantScore(String s) {
        int vowels = 0;
        int cons = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            } else if (Character.isLetter(ch)) {
                cons++;
            }
        }
        return cons > 0 ? (int) Math.floor((double) vowels / cons) : 0;
    }
}
