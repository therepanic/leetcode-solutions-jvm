package bitwiseORsOfSubarrays;

import java.util.HashSet;
import java.util.Set;

public class BitwiseORsOfSubarrays {
    public int subarrayBitwiseORs(int[] arr) {
        Set<Integer> current = new HashSet<>();
        Set<Integer> answer = new HashSet<>();
        for (int v : arr) {
            Set<Integer> a = new HashSet<>();
            a.add(v);
            for (int v2 : current) {
                a.add(v2 | v);
            }
            current = a;
            answer.addAll(current);
        }
        return answer.size();
    }
}
