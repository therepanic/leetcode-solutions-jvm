package doubleANumberRepresentedAsALinkedList;

import structures.listNode.ListNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class DoubleANumberRepresentedAsALinkedList {
    public ListNode doubleIt(ListNode head) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode temp = head;
        while (temp != null) {
            stack.addLast(temp);
            temp = temp.next;
        }
        int add = 0;
        while (!stack.isEmpty()) {
            ListNode node = stack.pollLast();
            int p = node.val * 2;
            if (p >= 10) {
                node.val = (p % 10) + add;
                add = 1;
            } else {
                node.val *= 2;
                node.val += add;
                add = 0;
            }
        }
        if (add == 1) {
            ListNode newNode = new ListNode(1);
            newNode.next = head;
            head = newNode;
        }
        return head;
    }
}
