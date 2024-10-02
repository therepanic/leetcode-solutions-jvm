package peekingIterator;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
    private final Iterator<Integer> iterator;
    private Integer cur;
    private Integer next;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        cur = iterator.next();

        if (iterator.hasNext()) {
            next = iterator.next();
        }
    }

    public Integer peek() {
        return cur;
    }

    @Override
    public Integer next() {
        Integer cur1 = cur;

        cur = next;

        next = null;

        if (iterator.hasNext()) {
            next = iterator.next();
        }

        return cur1;
    }

    @Override
    public boolean hasNext() {
        return cur != null;
    }
}
