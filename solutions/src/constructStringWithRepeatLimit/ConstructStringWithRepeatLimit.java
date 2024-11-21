package constructStringWithRepeatLimit;

import java.util.*;

public class ConstructStringWithRepeatLimit {
    public static String repeatLimitedString(String s, int repeatLimit) {
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        PriorityQueue<Character> heap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                heap.add((char) (i + 'a'));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!heap.isEmpty()) {
            char current = heap.poll();
            int curMinusA = current - 'a';

            for (int c = 0; c < repeatLimit && count[curMinusA] > 0; c++) {
                sb.append(current);
                count[curMinusA]--;
            }

            if (count[curMinusA] > 0) {
                if (heap.isEmpty()) {
                    return sb.toString();
                }

                char next = heap.peek();
                int nextA = next - 'a';

                sb.append(next);
                count[nextA]--;

                if (count[nextA] <= 0) {
                    heap.poll();
                }
                heap.add(current);
            }
        }


        return sb.toString();
    }
}
