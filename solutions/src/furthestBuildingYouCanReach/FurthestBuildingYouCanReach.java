package furthestBuildingYouCanReach;

import java.util.PriorityQueue;

public class FurthestBuildingYouCanReach {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 1; i < heights.length; i++) {
            int d = heights[i] - heights[i - 1];
            if (d > 0) {
                heap.add(d);
            }
            if (heap.size() > ladders) {
                bricks -= heap.poll();
            }
            if (bricks < 0) {
                return i - 1;
            }
        }
        return heights.length - 1;
    }
}
