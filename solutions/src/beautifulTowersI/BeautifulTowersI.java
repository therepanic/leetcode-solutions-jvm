package beautifulTowersI;

import java.util.*;

public class BeautifulTowersI {
    public static long maximumSumOfHeights(int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        long sum = 0;
        long allSum = 0;
        long[] del = new long[heights.length];
        for (int i = 0; i < heights.length; i++) {
            allSum += heights[i];
            int val = heights[i];
            int add = 0;
            while (!stack.isEmpty() && stack.getLast() > val) {
                sum += stack.pollLast() - val;
                add++;
            }
            for (int it = 0; it < add; it++) {
                stack.addLast(val);
            }
            stack.addLast(val);
            del[i] = sum;
        }
        stack.clear();
        sum = 0;
        for (int i = heights.length - 1; i >= 0; i--) {
            int val = heights[i];
            int add = 0;
            while (!stack.isEmpty() && stack.getLast() > val) {
                sum += stack.pollLast() - val;
                add++;
            }
            for (int it = 0; it < add; it++) {
                stack.addLast(val);
            }
            stack.addLast(val);
            del[i] += sum;
        }
        long answer = 0;
        for (int i = 0; i < heights.length; i++) {
            answer = Math.max(answer, allSum - del[i]);
        }
        return answer;
    }
}
