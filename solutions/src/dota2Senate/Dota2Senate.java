package dota2Senate;

import java.util.ArrayDeque;
import java.util.Deque;

public class Dota2Senate {
    public static String predictPartyVictory(String senate) {
        Deque<Integer> radiant = new ArrayDeque<>();
        Deque<Integer> dire = new ArrayDeque<>();

        for (int i = 0; i < senate.length(); i++) {
            if (senate.charAt(i) == 'D') {
                dire.add(i);
            } else {
                radiant.add(i);
            }
        }

        while (!radiant.isEmpty() && !dire.isEmpty()) {
            if (dire.peekFirst() < radiant.peekFirst()) {
                dire.addLast(dire.pollFirst() + senate.length());
                radiant.removeFirst();
            } else {
                radiant.addLast(radiant.pollFirst() + senate.length());
                dire.removeFirst();
            }
        }

        return dire.isEmpty() ? "Radiant" : "Dire";
    }
}
