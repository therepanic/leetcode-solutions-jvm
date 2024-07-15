package partitionList;

import structures.listNode.ListNode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy = head;

        ListNode newListNode = null;
        ListNode newListNodeDummy = null;

        ListNode prev = null;
        while (dummy != null) {
            if (dummy.val < x) {
                if (newListNode == null) {
                    newListNode = new ListNode();
                    newListNodeDummy = newListNode;
                }
                prev = newListNodeDummy;

                newListNodeDummy.val = dummy.val;
                newListNodeDummy.next = new ListNode();
                newListNodeDummy = newListNodeDummy.next;
            }

            dummy = dummy.next;
        }

        dummy = head;

        while (dummy != null) {
            if (dummy.val >= x) {
                if (newListNode == null) {
                    newListNode = new ListNode();
                    newListNodeDummy = newListNode;
                }
                prev = newListNodeDummy;

                newListNodeDummy.val = dummy.val;
                newListNodeDummy.next = new ListNode();
                newListNodeDummy = newListNodeDummy.next;
            }

            dummy = dummy.next;
        }

        if (prev != null) {
            prev.next = null;
        }

        return newListNode;
    }

}
