package copyListWithRandomPointer;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CopyListWithRandomPointer {
    public Node copyRandomList(Node head) {
        Random random = new Random();
        List<Node> nodes = new ArrayList<>();

        Node newNode = new Node(head.val);
        Node dummyNewNode = newNode;

        Node dummy = head;

        while (dummy != null) {
            nodes.add(dummy);
            dummy = dummy.next;
        }

        dummy = head;

        while (dummy != null) {
            dummyNewNode.next = dummy.next;

            dummyNewNode.random = nodes.get(random.nextInt(nodes.size()));

            dummyNewNode = dummyNewNode.next;
            dummy = dummy.next;
        }

        return newNode;
    }

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
