package maximumTwinSumOfALinkedList;

import structures.listNode.ListNode;

public class MaximumTwinSumOfALinkedList {
    public int pairSum(ListNode head) {
        ListNode slowAndMiddle = head;
        ListNode fast = head;

        while (fast != null) {
            slowAndMiddle = slowAndMiddle.next;

            fast = fast.next.next;
        }

        ListNode reversedMiddle = null;

        while (slowAndMiddle != null) {
            ListNode next = slowAndMiddle.next;

            slowAndMiddle.next = reversedMiddle;
            reversedMiddle = slowAndMiddle;

            slowAndMiddle = next;
        }

        int maxPairSum = 0;

        while (head != null && reversedMiddle != null) {
            maxPairSum = Math.max(maxPairSum, head.val + reversedMiddle.val);

            head = head.next;
            reversedMiddle = reversedMiddle.next;
        }

        return maxPairSum;
    }
}
