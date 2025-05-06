package theNumberOfWeakCharactersInTheGame;

import java.util.Arrays;

public class TheNumberOfWeakCharactersInTheGame {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                return Integer.compare(p1[1], p2[1]);
            } else {
                return Integer.compare(p2[0], p1[0]);
            }
        });
        int def = properties[0][1];
        int c = 0;
        for (int i = 1; i < properties.length; i++) {
            if (properties[i][1] < def) {
                c++;
            }
            def = Math.max(properties[i][1], def);
        }
        return c;
    }
}
