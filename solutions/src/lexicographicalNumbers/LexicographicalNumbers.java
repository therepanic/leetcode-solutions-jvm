package lexicographicalNumbers;

import java.util.LinkedList;
import java.util.List;

public class LexicographicalNumbers {
    public static List<Integer> lexicalOrder(int n) {
        List<Integer> lexicalOrder = new LinkedList<>();

        helper(lexicalOrder, 1, n);

        return lexicalOrder;
    }

    public static void helper(List<Integer> lexicalOrder, int n, int max) {
        if (n > max) {
            return;
        }

        int lastI = -1;
        for (int i = n; (i % 10) != 9 && i <= max; i++) {
            lastI = i;
            lexicalOrder.add(i);
            helper(lexicalOrder, i * 10, max);
        }

        lastI++;

        if (lastI % 10 == 9 && lastI <= max) {
            lexicalOrder.add(lastI);
            helper(lexicalOrder, lastI * 10, max);
        }
    }
}
