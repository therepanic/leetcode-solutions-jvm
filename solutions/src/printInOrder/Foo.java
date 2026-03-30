package printInOrder;

import java.util.concurrent.Semaphore;

public class Foo {

    private final Semaphore second = new Semaphore(0);

    private final Semaphore third = new Semaphore(0);

    public Foo() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        this.second.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        this.second.acquire();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        this.third.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        this.third.acquire();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
