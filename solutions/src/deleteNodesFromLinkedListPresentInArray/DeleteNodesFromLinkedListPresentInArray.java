package deleteNodesFromLinkedListPresentInArray;

import structures.listNode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class DeleteNodesFromLinkedListPresentInArray {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> numSet = new HashSet<>();
        for (int val : nums) {
            numSet.add(val);
        }

        ListNode answer = null;
        ListNode answerDummy = null;

        ListNode dummy = head;

        while (dummy != null) {
            ListNode next = dummy.next;

            if (answer == null && !numSet.contains(dummy.val)) {
                answer = dummy;
                dummy.next = null;

                answerDummy = answer;
            } else if (answer != null && !numSet.contains(dummy.val)) {
                answerDummy.next = dummy;
                dummy.next = null;

                answerDummy = answerDummy.next;
            }

            dummy = next;
        }

        return answer;
    }
}
