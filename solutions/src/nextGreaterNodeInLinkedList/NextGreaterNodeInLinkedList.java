package nextGreaterNodeInLinkedList;

import structures.listNode.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class NextGreaterNodeInLinkedList {
    public int[] nextLargerNodes(ListNode head) {
        int headSize = 0;

        ListNode dummy = head;
        while (dummy != null) {
            headSize++;

            dummy = dummy.next;
        }

        dummy = head;

        int i = 0;
        int[] nextLargerNodes = new int[headSize];
        Deque<Pair<Integer, Integer>> valueIndexPairDeque = new ArrayDeque<>();

        while (dummy != null) {
            if (valueIndexPairDeque.isEmpty()) {
                valueIndexPairDeque.addLast(new Pair<>(dummy.val, i));
            } else {
                while (!valueIndexPairDeque.isEmpty() && valueIndexPairDeque.getLast().firstValue < dummy.val) {
                    var lastValue = valueIndexPairDeque.getLast();

                    nextLargerNodes[lastValue.secondValue] = dummy.val;

                    valueIndexPairDeque.removeLast();
                }

                valueIndexPairDeque.addLast(new Pair<>(dummy.val, i));
            }

            i++;
            dummy = dummy.next;
        }

        return nextLargerNodes;
    }

    private static class Pair<T, L> {
        public T firstValue;
        public L secondValue;

        public Pair(T firstValue, L secondValue) {
            this.firstValue = firstValue;
            this.secondValue = secondValue;
        }
    }
}
