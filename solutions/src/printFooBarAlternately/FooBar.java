package printFooBarAlternately;

import java.util.concurrent.Semaphore;

public class FooBar {
    private int n;

    private final Semaphore semaphore1;

    private final Semaphore semaphore2;

    public FooBar(int n) {
        this.n = n;
        this.semaphore1 = new Semaphore(1);
        this.semaphore2 = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            this.semaphore1.acquire();
            printFoo.run();
            this.semaphore2.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            this.semaphore2.acquire();
            printBar.run();
            this.semaphore1.release();
        }
    }
}
