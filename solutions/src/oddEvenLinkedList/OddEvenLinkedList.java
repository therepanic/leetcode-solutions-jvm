package oddEvenLinkedList;

import structures.listNode.ListNode;

public class OddEvenLinkedList {
    public ListNode oddEvenList(ListNode head) {
        ListNode even = null;
        ListNode odd = null;

        ListNode evenDummy = null;
        ListNode oddDummy = null;

        ListNode prevEvenDummy = null;
        ListNode prevOddDummy = null;

        int i = 1;
        ListNode dummy = head;

        while (dummy != null) {
            if (i % 2 == 0) {
                if (even == null) {
                    even = new ListNode();
                    evenDummy = even;
                }

                prevEvenDummy = evenDummy;

                evenDummy.val = dummy.val;
                evenDummy.next = new ListNode();

                evenDummy = evenDummy.next;
            } else {
                if (odd == null) {
                    odd = new ListNode();
                    oddDummy = odd;
                }

                prevOddDummy = oddDummy;

                oddDummy.val = dummy.val;
                oddDummy.next = new ListNode();

                oddDummy = oddDummy.next;
            }

            i++;
            dummy = dummy.next;
        }

        if (even == null) {
            if (prevOddDummy != null) {
                prevOddDummy.next = null;
            }
            return odd;
        }

        prevOddDummy.next = even;

        prevEvenDummy.next = null;

        return odd;
    }
}
