package mergeInBetweenLinkedLists;

import structures.listNode.ListNode;

public class MergeInBetweenLinkedLists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode aPrevNode = null;
        ListNode bContNode = null;

        int i = 0;
        ListNode dummy = list1;

        while (dummy != null) {
            if (i + 1 == a) {
                aPrevNode = dummy;
            } else if (i - 1 == b) {
                bContNode = dummy;
                break;
            }
            i++;
            dummy = dummy.next;
        }

        aPrevNode.next = list2;

        ListNode list2EndNode = null;

        dummy = list2;

        while (dummy != null) {
            list2EndNode = dummy;

            dummy = dummy.next;
        }

        list2EndNode.next = bContNode;

        return list1;
    }
}
