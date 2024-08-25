package linkedListComponents;

import structures.listNode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class LinkedListComponents {

    public static int numComponents(ListNode head, int[] nums) {
        Set<Integer> numSet = new HashSet<>();

        for (int num : nums) {
            numSet.add(num);
        }

        int numComponents = 0;
        ListNode dummy = head;

        boolean interruption = false;

        while (dummy != null) {
            if (!numSet.contains(dummy.val) && interruption) {
                numComponents++;
                interruption = false;
            } else if (numSet.contains(dummy.val)) {
                interruption = true;
            }
            dummy = dummy.next;
        }

        if (interruption) {
            numComponents++;
        }

        return numComponents;
    }
}
