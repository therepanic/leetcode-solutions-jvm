package rotateList;

import structures.listNode.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        int headSize = 0;
        ListNode dummy = head;

        while (dummy != null) {
            headSize++;
            dummy = dummy.next;
        }

        if (headSize == 0) {
            return null;
        }

        if (k >= headSize) {
            k = k % headSize;
        }

        if (k == 0) {
            return head;
        }

        dummy = head;

        int trigger = 1;
        ListNode reversedHead = null;
        while (dummy != null) {
            if (trigger == headSize - k) {
                reversedHead = dummy.next;
                dummy.next = null;
                break;
            }
            trigger++;
            dummy = dummy.next;
        }

        dummy = reversedHead;

        while (dummy.next != null) {
            dummy = dummy.next;
        }

        dummy.next = head;
        return reversedHead;
    }
}
