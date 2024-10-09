package smallestNumberInInfiniteSet;

import java.util.HashSet;
import java.util.Set;

public class SmallestInfiniteSet {
    private final Set<Integer> deletedSet;
    private int small;
    public SmallestInfiniteSet() {
        this.deletedSet = new HashSet<>();
        this.small = 1;
    }

    public int popSmallest() {
        int num = small;
        deletedSet.add(num);

        do {
            small++;
        } while (deletedSet.contains(small));

        return num;
    }

    public void addBack(int num) {
        small = Math.min(small, num);
        deletedSet.remove(num);
    }
}
