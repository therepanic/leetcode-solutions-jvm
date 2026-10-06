package simplifiedFractions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SimplifiedFractions {
    public List<String> simplifiedFractions(int n) {
        List<String> answer = new ArrayList<>();
        Set<Double> has = new HashSet<>();
        for (int i = 1; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (has.add((double) i / j)) {
                    answer.add(i + "/" + j);
                }
            }
        }
        return answer;
    }
}
