package reorderList;

import structures.listNode.ListNode;

public class ReorderList {
    public static void reorderList(ListNode head) {
        ListNode beginSlowAfterMid = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            beginSlowAfterMid = beginSlowAfterMid.next ;
            fast = fast.next.next;
        }


        ListNode firstDummy = beginSlowAfterMid;
        ListNode reversedHalf = null;

        while (firstDummy != null) {
            ListNode temp = firstDummy.next;

            firstDummy.next = reversedHalf;
            reversedHalf = firstDummy;

            firstDummy = temp;
        }

        firstDummy = head;
        ListNode secDummy = reversedHalf;

        ListNode lastHigh = null;

        while (firstDummy != null && secDummy != null) {
            ListNode firstDummyNext = firstDummy.next;

            if (firstDummy == secDummy) {
                firstDummy = firstDummyNext;
                secDummy = secDummy.next;
                continue;
            }

            firstDummy.next = secDummy;

            if (lastHigh != null) {
                lastHigh.next = firstDummy;
            }

            lastHigh = secDummy;

            firstDummy = firstDummyNext;
            secDummy = secDummy.next;
        }
    }
}
