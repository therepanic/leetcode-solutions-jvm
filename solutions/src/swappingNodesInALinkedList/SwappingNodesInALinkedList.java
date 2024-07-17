package swappingNodesInALinkedList;

import structures.listNode.ListNode;

import java.util.ArrayList;
import java.util.List;

public class SwappingNodesInALinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        List<ListNode> nodes = new ArrayList<>();
        ListNode dummy = head;
        while (dummy != null) {
            nodes.add(dummy);

            dummy = dummy.next;
        }

        ListNode first = nodes.get(k - 1);
        ListNode second = nodes.get(nodes.size() - k);

        int buffer = first.val;

        first.val = second.val;
        second.val = buffer;

        return head;
    }
}
