package removeElementsByTypeAndColor;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveElementsByTypeAndColor {
    public boolean canRemoveAll(int[] types, int[] colors, int[] groupSize) {
        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < types.length; i++) {
            if (!stack.isEmpty() && stack.peekLast()[0] == types[i] && stack.peekLast()[1] == colors[i]) {
                stack.peekLast()[2]++;
                if (groupSize[types[i]] == stack.peekLast()[2]) {
                    stack.pollLast();
                }
            } else {
                stack.addLast(new int[] {types[i], colors[i], 1});
                if (groupSize[types[i]] == 1) {
                    stack.pollLast();
                }
            }
        }
        return stack.isEmpty();
    }
}
