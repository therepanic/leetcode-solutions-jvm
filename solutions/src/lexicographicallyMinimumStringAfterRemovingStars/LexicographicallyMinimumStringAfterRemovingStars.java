package lexicographicallyMinimumStringAfterRemovingStars;

import java.util.*;

public class LexicographicallyMinimumStringAfterRemovingStars {
    public static String clearStars(String s) {
        char[] sChars = s.toCharArray();
        PriorityQueue<int[]> heap = new PriorityQueue<>((p1, p2) -> {
            if (p1[0] == p2[0]) {
                return Integer.compare(p2[1], p1[1]);
            } else {
                return Character.compare((char) (p1[0]), (char) (p2[0]));
            }
        });
        boolean[] toDelete = new boolean[s.length()];
        for (int i = 0; i < sChars.length; i++) {
            if (sChars[i] != '*') {
                heap.add(new int[] {sChars[i], i});
            } else {
                int[] entry = heap.poll();
                toDelete[entry[1]] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sChars.length; i++) {
            if (!toDelete[i] && sChars[i] != '*') {
                sb.append(sChars[i]);
            }
        }
        return sb.toString();
    }
}
