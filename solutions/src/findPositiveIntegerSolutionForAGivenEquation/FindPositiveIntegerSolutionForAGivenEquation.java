package findPositiveIntegerSolutionForAGivenEquation;


/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */

import java.util.ArrayList;
import java.util.List;

public class FindPositiveIntegerSolutionForAGivenEquation {

    public static class CustomFunction {
        public int f(int x, int y) {
            return 0;
        }
    }

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        int x = 1;
        int y = 1000;
        List<List<Integer>> answer = new ArrayList<>();
        while (x <= 1000 && y > 0) {
            int a = customfunction.f(x, y);
            if (a > z) {
                y--;
            } else if (a < z) {
                x++;
            } else {
                answer.add(List.of(x--, y--));
            }
        }
        return answer;
    }
}
