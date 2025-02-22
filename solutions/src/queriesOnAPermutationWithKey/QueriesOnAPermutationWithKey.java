package queriesOnAPermutationWithKey;

import java.util.HashMap;
import java.util.Map;

public class QueriesOnAPermutationWithKey {
    public int[] processQueries(int[] queries, int m) {
        int[] P = new int[m];
        Map<Integer, Integer> position = new HashMap<>();
        for (int i = 0; i < m; i++) {
            P[i] = i + 1;
            position.put(i + 1, i);
        }

        int[] result = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int query = queries[i];
            int pos = position.get(query);
            result[i] = pos;

            for (int j = pos; j > 0; j--) {
                P[j] = P[j - 1];
                position.put(P[j], j);
            }
            P[0] = query;
            position.put(query, 0);
        }

        return result;
    }
}
