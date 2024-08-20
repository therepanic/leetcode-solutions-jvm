package insertGreatestCommonDivisorsInLinkedList;

import structures.listNode.ListNode;

public class InsertGreatestCommonDivisorsInLinkedList {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode dummy = head;

        while (dummy != null && dummy.next != null) {
            ListNode nextNode = dummy.next;

            ListNode newNode = new ListNode(gcd(dummy.val, nextNode.val));

            dummy.next = newNode;
            newNode.next = nextNode;

            dummy = nextNode;
        }

        return head;
    }

    public int gcd(int a, int b) {
        if (b == 0) return a;

        return gcd(b, a % b);
    }
}
