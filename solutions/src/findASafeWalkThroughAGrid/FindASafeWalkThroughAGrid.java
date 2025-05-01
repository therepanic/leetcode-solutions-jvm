package findASafeWalkThroughAGrid;

import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class FindASafeWalkThroughAGrid {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        PriorityQueue<int[]> heap = new PriorityQueue<>((p1, p2) -> Integer.compare(p2[2], p1[2]));
        heap.add(new int[] {0, 0, health});
        int[][] been = new int[grid.size()][grid.get(0).size()];
        for (int i = 0; i < grid.size(); i++) {
            Arrays.fill(been[i], -1);
        }
        while (!heap.isEmpty()) {
            int[] poll = heap.poll();
            poll[2] -= grid.get(poll[0]).get(poll[1]);
            if (been[poll[0]][poll[1]] >= poll[2]) continue;
            been[poll[0]][poll[1]] = poll[2];
            if (poll[2] <= 0) {
                continue;
            } else if (poll[0] == grid.size() - 1 && poll[1] == grid.get(0).size() - 1) {
                return true;
            }
            if (poll[0] + 1 < grid.size()) {
                heap.add(new int[] {poll[0] + 1, poll[1], poll[2]});
            }
            if (poll[0] - 1 >= 0) {
                heap.add(new int[] {poll[0] - 1, poll[1], poll[2]});
            }
            if (poll[1] + 1 < grid.get(0).size()) {
                heap.add(new int[] {poll[0], poll[1] + 1, poll[2]});
            }
            if (poll[1] - 1 >= 0) {
                heap.add(new int[] {poll[0], poll[1] - 1, poll[2]});
            }
        }
        return false;
    }
}
