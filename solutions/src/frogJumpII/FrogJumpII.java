package frogJumpII;

public class FrogJumpII {
    public int maxJump(int[] stones) {
        int maxDistance = 0;
        int i = 0;
        while (i < stones.length - 1) {
            int nextI = i + 2;
            if (nextI >= stones.length) {
                nextI--;
            }
            maxDistance = Math.max(maxDistance, stones[nextI] - stones[i]);
            i = nextI;
        }
        boolean even = i % 2 == 0;
        if (even) {
            maxDistance = Math.max(maxDistance, stones[stones.length - 1] - stones[stones.length - 2]);
            i--;
        }
        while (i > 0) {
            int nextI = i - 2;
            if (nextI < 0) {
                nextI++;
            }
            maxDistance = Math.max(stones[i] - stones[nextI], maxDistance);
            i = nextI;
        }
        return maxDistance;
    }
}
