package countResiduePrefixes;

import java.util.HashSet;
import java.util.Set;

public class CountResiduePrefixes {
    public int residuePrefixes(String s) {
        Set<Character> chars = new HashSet<>();
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            chars.add(s.charAt(i));
            if ((i + 1) % 3 == chars.size()) {
                c++;
            }
        }
        return c;
    }
}
