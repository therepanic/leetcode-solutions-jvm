package jewelsAndStones;

import java.util.HashSet;
import java.util.Set;

public class JewelsAndStones {
    public int numJewelsInStones(String jewels, String stones) {
        Set<Character> chars = new HashSet<>();
        int c = 0;
        for (int i = 0; i < jewels.length(); i++) {
            chars.add(jewels.charAt(i));
        }
        for (int i = 0; i < stones.length(); i++) {
            c += chars.contains(stones.charAt(i)) ? 1 : 0;
        }
        return c;
    }
}
