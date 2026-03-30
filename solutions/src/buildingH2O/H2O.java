package buildingH2O;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class H2O {

    private final Object sync = new Object();

    private Semaphore hydroAdded = new Semaphore(2);

    private Semaphore oxyAdded = new Semaphore(1);

    private CyclicBarrier barrier = new CyclicBarrier(3);

    public H2O() {

    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        this.hydroAdded.acquire();
        releaseHydrogen.run();
        try {
            this.barrier.await();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        this.hydroAdded.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        this.oxyAdded.acquire();
        releaseOxygen.run();
        try {
            this.barrier.await();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
        this.oxyAdded.release();
    }
}
