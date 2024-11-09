package copyListWithRandomPointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CopyListWithRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
        }
    }

    public Node copyRandomList(Node head) {
        if (head == null) return null;
        Node newNode = new Node(head.val);
        Node temp1 = newNode;

        Node temp = head;

        List<Node> nodeList = new ArrayList<>();

        while (temp != null) {
            nodeList.add(temp1);
            if (temp.next != null) {
                temp1.next = new Node(temp.next.val);
                temp1 = temp1.next;
            }
            temp = temp.next;
        }

        Map<Node, Integer> map = new HashMap<>();

        int i = 0;
        temp = head;

        while (temp != null) {
            map.put(temp, i);

            temp = temp.next;
            i++;
        }
        i = 0;
        temp = head;

        while (temp != null) {
            if (temp.random != null) {
                int index = map.get(temp.random);

                nodeList.get(i).random = nodeList.get(index);
            }

            temp = temp.next;
            i++;
        }

        return newNode;
    }
}

