package flattenNestedListIterator;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;

public class NestedIterator implements Iterator<Integer> {

    private final Queue<Integer> values;

    public NestedIterator(List<NestedInteger> nestedList) {
        this.values = new ArrayDeque<>();
        dfs(this.values, nestedList);
    }

    private void dfs(Queue<Integer> values, List<NestedInteger> nodes) {
        for (var node : nodes) {
            if (node.isInteger()) {
                values.add(node.getInteger());
            } else {
                dfs(values, node.getList());
            }
        }
    }

    @Override
    public boolean hasNext() {
        return !this.values.isEmpty();
    }

    @Override
    public Integer next() {
        return this.values.poll();
    }

    public interface NestedInteger {

        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();

    }


}

