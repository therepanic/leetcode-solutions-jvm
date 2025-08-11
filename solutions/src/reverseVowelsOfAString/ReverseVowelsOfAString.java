package reverseVowelsOfAString;

import java.util.HashSet;
import java.util.Set;

public class ReverseVowelsOfAString {
    static Set<Character> vowels = new HashSet<>(Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    public String reverseVowels(String s) {
        int l = 0;
        int r = s.length() - 1;
        char[] sChars = s.toCharArray();

        while (l <= r) {
            if (vowels.contains(sChars[l]) && vowels.contains(sChars[r])) {
                char buffer = sChars[l];
                sChars[l] = sChars[r];
                sChars[r] = buffer;
                l++;
                r--;
            } else if (!vowels.contains(sChars[l])) {
                l++;
            } else {
                r--;
            }
        }
        return String.valueOf(sChars);
    }
}
