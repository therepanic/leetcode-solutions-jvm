package openTheLock;

import java.util.*;

public class OpenTheLock {
    public static int openLock(String[] deadends, String target) {
        Set<String> checked = new HashSet<>(Arrays.stream(deadends).toList());
        Queue<StringBuilder> bfs = new ArrayDeque<>(List.of(new StringBuilder("0000")));
        int c = 0;
        while (!bfs.isEmpty()) {
            int size = bfs.size();
            for (int i = 0; i < size; i++) {
                StringBuilder poll = bfs.poll();
                String pollStr = poll.toString();
                if (target.equals(pollStr)) {
                    return c;
                }
                if (checked.contains(pollStr)) continue;
                checked.add(pollStr);
                for (int j = 0; j < poll.length(); j++) {
                    int val = Character.getNumericValue(poll.charAt(j));
                    int newVal1 = (val + 1) % 9;
                    poll.setCharAt(j, Character.forDigit(newVal1, 10));
                    bfs.add(new StringBuilder(poll));
                    int newVal2 = (val - 1) % 9;
                    if (newVal2 < 0) newVal2 = 9;
                    poll.setCharAt(j, Character.forDigit(newVal2, 10));
                    bfs.add(new StringBuilder(poll));
                    poll.setCharAt(j, Character.forDigit(val, 10));
                }
            }
            c++;
        }
        return -1;
    }
}
