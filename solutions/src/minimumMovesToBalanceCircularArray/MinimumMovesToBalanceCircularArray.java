package minimumMovesToBalanceCircularArray;

import java.util.TreeSet;

public class MinimumMovesToBalanceCircularArray {
    public long minMoves(int[] balance) {
        TreeSet<Integer> indexPos = new TreeSet<>();
        long pos = 0;
        long neg = 0;
        for (int i = 0; i < balance.length; i++) {
            if (balance[i] > 0) {
                indexPos.add(i);
                pos += balance[i];
            } else {
                neg += balance[i];
            }
        }
        if (-neg > pos) {
            return -1;
        }
        long moves = 0;
        for (int i = 0; i < balance.length; i++) {
            while (!indexPos.isEmpty() && balance[i] < 0) {
                Integer lowest = indexPos.lower(i);
                Integer highest = indexPos.higher(i);
                Integer preHighest = indexPos.first();
                Integer preLow = indexPos.last();
                int lowestMoves = Integer.MAX_VALUE;
                int highestMoves = Integer.MAX_VALUE - 1;
                int preHighestMoves = Integer.MAX_VALUE - 2;
                int preLowMoves = Integer.MAX_VALUE - 2;
                if (lowest == null && highest == null && preHighest == null) {
                    return -1;
                }
                if (lowest != null) {
                    lowestMoves = i - lowest;
                }
                if (highest != null) {
                    highestMoves = highest - i;
                }
                if (preHighest != null && preHighest < i) {
                    preHighestMoves = (balance.length - i) + preHighest;
                }
                if (preLow != null && preLow > i) {
                    preLowMoves = i + (balance.length - preLow);
                }
                int id = -1;
                int actualDistance = 0;
                if (lowest != null && lowestMoves <= highestMoves && lowestMoves <= preHighestMoves && lowestMoves <= preLowMoves) {
                    id = lowest;
                    actualDistance = lowestMoves;
                } else if (highest != null && highestMoves <= lowestMoves && highestMoves <= preHighestMoves && highestMoves <= preLowMoves) {
                    id = highest;
                    actualDistance = highestMoves;
                } else if (preHighest != null && preHighestMoves <= lowestMoves && preHighestMoves <= highestMoves && preHighestMoves <= preLowMoves) {
                    id = preHighest;
                    actualDistance = preHighestMoves;
                } else if (preLow != null && preLowMoves <= lowestMoves && preLowMoves <= highestMoves && preLowMoves <= preHighestMoves) {
                    id = preLow;
                    actualDistance = preLowMoves;
                }
                int minToDel = Math.min(-balance[i], balance[id]);
                balance[i] += minToDel;
                balance[id] -= minToDel;
                if (balance[id] == 0) {
                    indexPos.remove(id);
                }
                moves += (long) actualDistance * minToDel;
            }
        }
        return moves;
    }
}
