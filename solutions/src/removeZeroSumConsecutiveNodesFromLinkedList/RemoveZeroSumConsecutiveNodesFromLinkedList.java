package removeZeroSumConsecutiveNodesFromLinkedList;

import structures.listNode.ListNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveZeroSumConsecutiveNodesFromLinkedList {
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, List<ListNode>> keyListNodeMap = new HashMap<>();

        ListNode dummy = head;

        int sum = 0;
        while (dummy != null) {
            sum += dummy.val;

            if (sum == 0) {
                head = dummy.next;
            } else if (keyListNodeMap.containsKey(sum)) {
                for (ListNode node : keyListNodeMap.get(sum)) {
                    node.next = dummy.next;
                }

                keyListNodeMap.get(sum).add(dummy);
            }

            if (!keyListNodeMap.containsKey(sum)) {
                keyListNodeMap.put(sum, new ArrayList<>(List.of(dummy)));
            }

            dummy = dummy.next;
        }

        return head;
    }
}
