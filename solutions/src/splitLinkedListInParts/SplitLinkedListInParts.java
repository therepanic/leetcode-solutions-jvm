package splitLinkedListInParts;

import structures.listNode.ListNode;

public class SplitLinkedListInParts {
    public static ListNode[] splitListToParts(ListNode head, int k) {
        ListNode dummy = head;
        int headSize = 0;

        while (dummy != null) {
            headSize++;
            dummy = dummy.next;
        }

        int partitionSize = headSize / k;
        int residue = headSize % k;
        dummy = head;

        ListNode[] listNodes = new ListNode[k];

        int listNodesI = 0;

        int size = 1;

        while (dummy != null) {
            ListNode node = dummy.next;

            if (size == partitionSize && residue == 0) {
                dummy.next = null;
                listNodes[listNodesI] = head;

                head = node;

                listNodesI++;

                dummy = node;

                size = 1;
                continue;
            } else if (size == partitionSize + 1 && residue != 0) {
                dummy.next = null;
                listNodes[listNodesI] = head;

                head = node;

                listNodesI++;

                dummy = node;

                size = 1;

                residue--;
                continue;
            }

            dummy = node;
            size++;
        }
        return listNodes;
    }
}
