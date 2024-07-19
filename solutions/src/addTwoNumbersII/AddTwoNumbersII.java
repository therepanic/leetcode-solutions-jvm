package addTwoNumbersII;

import structures.listNode.ListNode;

import java.math.BigInteger;

public class AddTwoNumbersII {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        StringBuilder l1ValuesString = new StringBuilder();
        StringBuilder l2ValuesString = new StringBuilder();

        ListNode dummy = l1;

        while (dummy != null) {
            l1ValuesString.append(dummy.val);

            dummy = dummy.next;
        }

        dummy = l2;

        while (dummy != null) {
            l2ValuesString.append(dummy.val);
            dummy = dummy.next;
        }
        char[] l1ValuesSumStringChars = new BigInteger(l1ValuesString.toString()).add(new BigInteger(l2ValuesString.toString())).toString().toCharArray();

        ListNode newListNode = new ListNode();
        ListNode prev = null;

        dummy = newListNode;

        for (char c : l1ValuesSumStringChars) {
            dummy.val = Character.getNumericValue(c);

            prev = dummy;
            dummy.next = new ListNode();
            dummy = dummy.next;
        }

        if (prev != null) {
            prev.next = null;
        }

        return newListNode;
    }
}
