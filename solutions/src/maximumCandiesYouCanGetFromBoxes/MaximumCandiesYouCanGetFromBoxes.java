package maximumCandiesYouCanGetFromBoxes;

import java.util.*;

public class MaximumCandiesYouCanGetFromBoxes {

    public static int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        Set<Integer> haveKeys = new HashSet<>();
        for (int i = 0; i < status.length; i++) {
            if (status[i] == 1) {
                haveKeys.add(i);
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        for (int b : initialBoxes) {
            queue.add(b);
        }
        Set<Integer> visited = new HashSet<>();
        Set<Integer> waitingBoxes = new HashSet<>();
        int totalCandies = 0;
        while (!queue.isEmpty()) {
            int box = queue.poll();
            if (visited.contains(box)) {
                continue;
            }
            if (status[box] == 0 && !haveKeys.contains(box)) {
                waitingBoxes.add(box);
                continue;
            }
            visited.add(box);
            totalCandies += candies[box];
            for (int k : keys[box]) {
                if (!haveKeys.contains(k)) {
                    haveKeys.add(k);
                    if (waitingBoxes.contains(k)) {
                        waitingBoxes.remove(k);
                        queue.add(k);
                    }
                }
            }
            for (int nxt : containedBoxes[box]) {
                if (!visited.contains(nxt)) {
                    queue.add(nxt);
                }
            }
        }
        return totalCandies;
    }

}
