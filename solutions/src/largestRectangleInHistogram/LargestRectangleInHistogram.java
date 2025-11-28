package largestRectangleInHistogram;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        Deque<Integer> mono = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            while (!mono.isEmpty() && heights[i] < heights[mono.getLast()]) {
                int h = heights[mono.pollLast()];
                int l = mono.isEmpty() ? -1 : mono.peekLast();
                maxArea = Math.max(maxArea,  h * (i - l - 1));
            }
            mono.addLast(i);
        }
        while (!mono.isEmpty() && 0 < heights[mono.getLast()]) {
            int h = heights[mono.pollLast()];
            int l = mono.isEmpty() ? -1 : mono.peekLast();
            maxArea = Math.max(maxArea,  h * (heights.length - l - 1));
        }
        return maxArea;
    }
}
