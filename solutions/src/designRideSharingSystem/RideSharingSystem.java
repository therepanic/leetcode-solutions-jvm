package designRideSharingSystem;

import java.util.*;

public class RideSharingSystem {

    private final Queue<Integer> drivers;

    private final LinkedHashSet<Integer> riders;

    public RideSharingSystem() {
        this.drivers = new ArrayDeque<>();
        this.riders = new LinkedHashSet<>();
    }

    public void addRider(int riderId) {
        this.riders.add(riderId);
    }

    public void addDriver(int driverId) {
        this.drivers.add(driverId);
    }

    public int[] matchDriverWithRider() {
        if (this.drivers.isEmpty() || this.riders.isEmpty()) {
            return new int[] {-1, -1};
        }
        int riderId = this.riders.getFirst();
        this.riders.remove(riderId);
        return new int[] {this.drivers.poll(), riderId};
    }

    public void cancelRider(int riderId) {
        this.riders.remove(riderId);
    }
}
