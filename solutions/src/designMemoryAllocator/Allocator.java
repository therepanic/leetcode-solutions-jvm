package designMemoryAllocator;

public class Allocator {
    private final int[] mem;
    public Allocator(int n) {
        this.mem = new int[n];
    }

    public int allocate(int size, int mID) {
        int id = -1;

        int curSize = 0;

        for (int i = 0; i < mem.length; i++) {
            if (mem[i] == 0) {
                curSize++;
            } else {
                curSize = 0;
            }

            if (curSize == size) {
                int b = i - size + 1;

                for (int j = b; j < b + size; j++) {
                    if (id == -1) id = j;

                    mem[j] = mID;
                }
                break;
            }
        }

        return id;
    }

    public int free(int mID) {
        int memCount = 0;

        for (int i = 0; i < mem.length; i++) {
            if (mem[i] == mID) {
                memCount++;
                mem[i] = 0;
            }
        }

        return memCount;
    }
}
