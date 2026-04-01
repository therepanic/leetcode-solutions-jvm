package revealCardsInIncreasingOrder;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class RevealCardsInIncreasingOrder {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Deque<Integer> deq = new ArrayDeque<>();
        int[] ans = new int[deck.length];
        for (int i = 0; i < deck.length; i++) {
            deq.add(i);
        }
        for (int val : deck) {
            ans[deq.pollFirst()] = val;
            if (!deq.isEmpty()) {
                deq.addLast(deq.pollFirst());
            }
        }
        return ans;
    }
}
