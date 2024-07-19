package insertionSortList;

import structures.listNode.ListNode;

import java.util.*;

public class InsertionSortList {
    public static ListNode insertionSortList(ListNode head) {
        List<ListNode> listNodes = new ArrayList<>();
        ListNode dummy = head;

        while (dummy != null) {
            listNodes.add(dummy);

            dummy = dummy.next;
        }


        for (int i = 1; i < listNodes.size(); i++) {
            int copyI = i;

            while (listNodes.get(copyI) != null && copyI >= 1 && listNodes.get(copyI).val < listNodes.get(copyI - 1).val) {
                int bufferVal = listNodes.get(copyI).val;

                listNodes.get(copyI).val = listNodes.get(copyI - 1).val;
                listNodes.get(copyI - 1).val = bufferVal;
                copyI--;
            }
        }

        return head;
    }
}
