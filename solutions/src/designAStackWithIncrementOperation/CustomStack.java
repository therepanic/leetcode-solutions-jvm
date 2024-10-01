package designAStackWithIncrementOperation;

public class CustomStack {
    private int i;
    private final int[] stack;

    public CustomStack(int maxSize) {
        this.stack = new int[maxSize];
        this.i = 0;
    }

    public void push(int x) {
        if (i == stack.length) return;
        stack[i] = x;
        i++;
    }

    public int pop() {
        if (i == 0) return -1;
        i--;
        return stack[i];
    }

    public void increment(int k, int val) {
        for (int j = 0; j < Math.min(k, i); j++) {
            stack[j] += val;
        }
    }
}

