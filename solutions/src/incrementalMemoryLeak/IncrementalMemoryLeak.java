package incrementalMemoryLeak;

public class IncrementalMemoryLeak {
    public int[] memLeak(int memory1, int memory2) {
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (memory1 < i && memory2 < i) {
                return new int[] {i, memory1, memory2};
            } else {
                if (memory1 >= memory2) {
                    memory1 -= i;
                } else {
                    memory2 -= i;
                }
            }
        }
        return null;
    }
}
