package printZeroEvenOdd;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class ZeroEvenOdd {
    private int n;

    private int c = 1;

    private boolean nextEven = false;

    private final Semaphore zero = new Semaphore(1);

    private final Semaphore odd = new Semaphore(0);

    private final Semaphore even = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 0; i < n; i++) {
            this.zero.acquire();
            printNumber.accept(0);
            if (!this.nextEven) {
                this.odd.release();
            } else {
                this.even.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            this.even.acquire();
            printNumber.accept(this.c++);
            this.nextEven = false;
            this.zero.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            this.odd.acquire();
            printNumber.accept(this.c++);
            this.nextEven = true;
            this.zero.release();
        }
    }
}
