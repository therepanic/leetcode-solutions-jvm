package letterTilePossibilities;

import java.util.HashMap;
import java.util.Map;

public class LetterTilePossibilities {
    public static int numTilePossibilities(String tiles) {
        char[] tileChars = tiles.toCharArray();

        Map<Character, Integer> charCountMap = new HashMap<>();

        for (char c : tileChars) {
            if (charCountMap.containsKey(c)) {
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {
                charCountMap.put(c, 1);
            }
        }

        int[] numsTiles = new int[1];

        helper(numsTiles, charCountMap);

        return numsTiles[0];
    }

    public static void helper(int[] numTiles, Map<Character, Integer> charCountMap) {
        for (Map.Entry<Character, Integer> entry : charCountMap.entrySet()) {
            if (entry.getValue() == 0) {
                continue;
            }

            charCountMap.put(entry.getKey(), charCountMap.get(entry.getKey()) - 1);

            helper(numTiles, charCountMap);

            numTiles[0]++;

            charCountMap.put(entry.getKey(), charCountMap.get(entry.getKey()) + 1);
        }
    }
}
