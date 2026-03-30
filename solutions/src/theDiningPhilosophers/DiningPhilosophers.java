package theDiningPhilosophers;

public class DiningPhilosophers {
    private final Object[] forks = new Object[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            this.forks[i] = new Object();
        }
    }

    public synchronized void wantsToEat(int philosopher,
                                        Runnable pickLeftFork,
                                        Runnable pickRightFork,
                                        Runnable eat,
                                        Runnable putLeftFork,
                                        Runnable putRightFork) throws InterruptedException {
        int left = philosopher;
        int right = (philosopher + 1) % 5;
        if (philosopher % 2 == 0) {
            synchronized (this.forks[left]) {
                synchronized (this.forks[right]) {
                    pickLeftFork.run();
                    pickRightFork.run();
                    eat.run();
                    putLeftFork.run();
                    putRightFork.run();
                }
            }
        } else {
            synchronized (this.forks[right]) {
                synchronized (this.forks[left]) {
                    pickLeftFork.run();
                    pickRightFork.run();
                    eat.run();
                    putLeftFork.run();
                    putRightFork.run();
                }
            }
        }
    }
}