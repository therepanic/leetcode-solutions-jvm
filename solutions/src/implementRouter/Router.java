package implementRouter;

import java.util.*;

public class Router {

    static class Package {
        public final int source;
        public final int destination;
        public final int timestamp;

        public Package(int source, int destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Package aPackage = (Package) o;

            if (source != aPackage.source) return false;
            if (destination != aPackage.destination) return false;
            return timestamp == aPackage.timestamp;
        }

        @Override
        public int hashCode() {
            int result = source;
            result = 31 * result + destination;
            result = 31 * result + timestamp;
            return result;
        }
    }

    private final LinkedHashSet<Package> all;
    private final Map<Integer, List<Integer>> allz;
    private final int memoryLimit;

    public Router(int memoryLimit) {
        this.all = new LinkedHashSet<>(memoryLimit);
        this.memoryLimit = memoryLimit;
        this.allz = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Package pockage = new Package(source, destination, timestamp);
        if (all.contains(pockage)) {
            return false;
        }
        if (all.size() == memoryLimit) {
            forwardPacket();
        }
        all.add(pockage);
        allz.computeIfAbsent(destination, m -> new ArrayList<>()).add(timestamp);
        return true;
    }

    public int[] forwardPacket() {
        if (all.isEmpty()) {
            return new int[0];
        }
        int[] packet = new int[3];
        Package pockage = all.getFirst();
        all.removeFirst();
        packet[0] = pockage.source;
        packet[1] = pockage.destination;
        packet[2] = pockage.timestamp;
        allz.get(pockage.destination).remove(Integer.valueOf(pockage.timestamp));
        return packet;
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> interval = allz.getOrDefault(destination, Collections.emptyList());
        if (interval.isEmpty()) {
            return 0;
        }
        int left = minBinary(interval, startTime);
        int right = maxBinary(interval, endTime);
        if (left > right) {
            return 0;
        }
        return right - left + 1;
    }

    private int minBinary(List<Integer> interval, int startTime) {
        int l = 0;
        int r = interval.size() - 1;
        int answer = interval.size();
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (interval.get(mid) >= startTime) {
                answer = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return answer;
    }

    private int maxBinary(List<Integer> interval, int endTime) {
        int l = 0;
        int r = interval.size() - 1;
        int answer = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (interval.get(mid) <= endTime) {
                answer = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return answer;
    }
}
