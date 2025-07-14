package convertBinaryNumberInALinkedListToInteger;

import structures.listNode.ListNode;

public class ConvertBinaryNumberInALinkedListToInteger {

    public int getDecimalValue(ListNode head) {
        StringBuilder val = new StringBuilder();
        ListNode dummy = head;
        while (dummy != null) {
            val.append(dummy.val);
            dummy = dummy.next;
        }
        return Integer.parseInt(String.valueOf(val), 2);
    }

}
