package fizzBuzzMultithreaded;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz {
    private int n;

    private final Semaphore fizz = new Semaphore(0);

    private final Semaphore buzz = new Semaphore(0);

    private final Semaphore fizzbuzz = new Semaphore(0);

    private final Semaphore number = new Semaphore(1);

    private int count = 1;

    public FizzBuzz(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException {
        while (true) {
            this.fizz.acquire();
            if (this.count > this.n) {
                this.fizz.release();
                return;
            }
            printFizz.run();
            this.count++;
            apply();
        }
    }

    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (true) {
            this.buzz.acquire();
            if (this.count > this.n) {
                this.buzz.release();
                return;
            }
            printBuzz.run();
            this.count++;
            apply();
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (true) {
            this.fizzbuzz.acquire();
            if (this.count > this.n) {
                this.fizzbuzz.release();
                return;
            }
            printFizzBuzz.run();
            this.count++;
            apply();
        }
    }

    public void number(IntConsumer printNumber) throws InterruptedException {
        while (true) {
            this.number.acquire();
            if (this.count > this.n) {
                this.number.release();
                return;
            }
            printNumber.accept(this.count++);
            apply();
        }
    }

    private void apply() throws InterruptedException {
        if (this.count > this.n) {
            this.fizz.release();
            this.buzz.release();
            this.fizzbuzz.release();
            this.number.release();
            return;
        }
        if (this.count % 3 == 0 && this.count % 5 == 0) {
            this.fizzbuzz.release();
        } else if (this.count % 3 == 0 && this.count % 5 != 0) {
            this.fizz.release();
        } else if (this.count % 3 != 0 && this.count % 5 == 0) {
            this.buzz.release();
        } else {
            this.number.release();
        }
    }
}
