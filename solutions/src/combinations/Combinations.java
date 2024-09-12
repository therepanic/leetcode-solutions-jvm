package combinations;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();

        helper(n, k, 1, answer, new ArrayList<>());

        return answer;
    }

    public void helper(int n, int k, int curValue, List<List<Integer>> answer, List<Integer> perm) {
        for (int i = curValue; i <= n; i++) {
            if (perm.size() < k) {
                perm.add(i);

                helper(n, k, i + 1, answer, perm);

                if (perm.size() == k) {
                    answer.add(new ArrayList<>(perm));
                }

                perm.removeLast();
            }
        }
    }
}
