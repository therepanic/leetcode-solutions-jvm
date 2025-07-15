package validWord;

public class ValidWord {

    public boolean isValid(String word) {
        if (word.length() < 3) return false;
        boolean oneVowel = false;
        boolean oneConsonant = false;
        for (char c : word.toCharArray()) {
            if (!Character.isDigit(c) && !Character.isLetter(c)) {
                return false;
            } else if (Character.isLetter(c)) {
                char small = Character.toLowerCase(c);
                if (small == 'a' || small == 'e' || small == 'i' || small == 'o' || small == 'u') {
                    oneVowel = true;
                } else {
                    oneConsonant = true;
                }
            }
        }
        return oneConsonant && oneVowel;
    }

}
