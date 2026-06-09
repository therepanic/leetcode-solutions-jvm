package passwordStrength;

import java.util.HashSet;
import java.util.Set;

public class PasswordStrength {
    public int passwordStrength(String password) {
        Set<Character> has = new HashSet<>();
        int s = 0;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (!has.contains(ch)) {
                if (Character.isLetter(ch)) {
                    if (Character.isLowerCase(ch)) {
                        s++;
                    } else {
                        s += 2;
                    }
                } else if (Character.isDigit(ch)) {
                    s += 3;
                } else {
                    s += 5;
                }
                has.add(ch);
            }
        }
        return s;
    }
}
