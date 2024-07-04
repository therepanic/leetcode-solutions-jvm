package mergeNodesInBetweenZeros;

import structures.listNode.ListNode;

public class MergeNodesInBetweenZeros {
    public ListNode mergeNodes(ListNode head) {
        ListNode newNode = new ListNode();
        ListNode newNodeDummy = newNode;
        ListNode prevNewNodeDummy = null;

        int value = -1;
        ListNode dummyHead = head;

        while (dummyHead != null) {
            if (value != -1 && dummyHead.val == 0) {
                prevNewNodeDummy = newNodeDummy;

                newNodeDummy.val = value;
                newNodeDummy.next = new ListNode();
                newNodeDummy = newNodeDummy.next;

                value = 0;
                dummyHead = dummyHead.next;
                continue;
            } else if (value == - 1 && dummyHead.val == 0) {
                value = 0;
                dummyHead = dummyHead.next;
                continue;
            }

            value += dummyHead.val;
            dummyHead = dummyHead.next;
        }
        if (prevNewNodeDummy != null) {
            prevNewNodeDummy.next = null;
        }

        return newNode;
    }
}
