package flattenAMultilevelDoublyLinkedList;

public class FlattenAMultilevelDoublyLinkedList {

    public Node flatten(Node head) {
        return bypass(head)[0];
    }

    public Node[] bypass(Node head) {
        Node dummy = head;
        Node prev = null;
        while (dummy != null) {
            if (prev == null) {
                prev = dummy;
            } else {
                dummy.prev = prev;
                prev = dummy;
            }
            if (dummy.child != null) {
                Node[] poll = bypass(dummy.child);
                Node temp = poll[0];
                temp.prev = dummy;
                dummy.child = null;
                Node nextTemp = dummy.next;
                dummy.next = temp;
                poll[1].next = nextTemp;
            }
            dummy = dummy.next;
        }
        return new Node[] {head, prev};
    }

    static class Node {
        public int val;
        public Node prev;
        public Node next;
        public Node child;
    };
}
