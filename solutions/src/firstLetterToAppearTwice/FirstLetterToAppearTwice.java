package firstLetterToAppearTwice;

import java.util.HashSet;
import java.util.Set;

public class FirstLetterToAppearTwice {
    public char repeatedCharacter(String s) {
        Set<Character> characterSet = new HashSet<>();

        for (char c : s.toCharArray()) {
            if (characterSet.contains(c)) {
                return c;
            } else {
                characterSet.add(c);
            }
        }

        return '-';
    }

}
