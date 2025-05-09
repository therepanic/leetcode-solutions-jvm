package checkIfWordIsValidAfterSubstitutions;

import java.util.ArrayList;
import java.util.List;

public class CheckIfWordIsValidAfterSubstitutions {
    public boolean isValid(String s) {
        List<Character> characters = new ArrayList<>();
        for (char c : s.toCharArray()) {
            characters.add(c);
            if (characters.size() >= 3) {
                int size = characters.size();
                if (characters.get(size - 3) == 'a' && characters.get(size - 2) == 'b' && characters.get(size - 1) == 'c') {
                    characters.removeLast();
                    characters.removeLast();
                    characters.removeLast();
                }
            }
        }
        return characters.isEmpty();
    }
}
