package rabbitsInForest;

import java.util.HashMap;
import java.util.Map;

public class RabbitsInForest {
    public static int numRabbits(int[] answers) {
        Map<Integer, Integer> rabbits = new HashMap<>();
        int zero = 0;
        for (int answer : answers) {
            if (answer == 0) {
                zero++;
            } else {
                rabbits.put(answer, rabbits.getOrDefault(answer, 0) + 1);
            }
        }
        int c = 0;
        for (var entry : rabbits.entrySet()) {
            int need = entry.getKey() + 1;
            int count = (int) (Math.ceil((double) entry.getValue() / need));
            c += count * need;
        }
        c += zero;
        return c;
    }
}
