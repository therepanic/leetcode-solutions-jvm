package intersectionOfTwoLinkedLists;

import structures.listNode.ListNode;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> listNodeSet = new HashSet<>();

        while (headA != null || headB != null) {
            if (headA != null) {
                if (listNodeSet.contains(headA)) {
                    return headA;
                }
                listNodeSet.add(headA);
                headA = headA.next;
            }

            if (headB != null) {
                if (listNodeSet.contains(headB)) {
                    return headB;
                }
                listNodeSet.add(headB);
                headB = headB.next;
            }
        }

        return null;
    }
}
