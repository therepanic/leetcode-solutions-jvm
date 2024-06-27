package mergeKSortedLists;

import structures.listNode.ListNode;

import java.util.*;

public class MergeKSortedLists {
    public static ListNode mergeKLists(ListNode[] listNodes) {
        ListNode newListNode = new ListNode();
        ListNode dummy = newListNode;

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < listNodes.length; i++) {
            while (listNodes[i] != null) {
                list.add(listNodes[i].val);

                listNodes[i] = listNodes[i].next;
            }
        }

        if (list.isEmpty()) {
            return null;
        }

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            dummy.val = list.get(i);

            if (i != list.size() - 1) {
                dummy.next = new ListNode();
                dummy = dummy.next;
            }
        }

        return newListNode;
    }
}
