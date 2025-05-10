package beautifulTowersII;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class BeautifulTowersII {
    record Node(int val, long count) {}

    public long maximumSumOfHeights(List<Integer> maxHeights) {
        Deque<Node> stack = new ArrayDeque<>();
        long sum = 0;
        long allSum = 0;
        long[] del = new long[maxHeights.size()];
        for (int i = 0; i < maxHeights.size(); i++) {
            allSum += maxHeights.get(i);
            int val = maxHeights.get(i);
            long add = 0;
            while (!stack.isEmpty() && stack.getLast().val() > val) {
                Node last = stack.pollLast();
                sum += (long) (last.val() - val) * last.count();
                add += last.count();
            }
            stack.addLast(new Node(val, add + 1));
            del[i] = sum;
        }
        stack.clear();
        sum = 0;
        for (int i = maxHeights.size() - 1; i >= 0; i--) {
            int val = maxHeights.get(i);
            long add = 0;
            while (!stack.isEmpty() && stack.getLast().val() > val) {
                Node last = stack.pollLast();
                sum += (long) (last.val() - val) * last.count();
                add += last.count();
            }
            stack.addLast(new Node(val, add + 1));
            del[i] += sum;
        }
        long answer = 0;
        for (int i = 0; i < maxHeights.size(); i++) {
            answer = Math.max(answer, allSum - del[i]);
        }
        return answer;
    }
}
