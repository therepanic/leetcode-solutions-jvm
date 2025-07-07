package digitOperationsToMakeTwoIntegersEqual;

import java.util.*;

public class DigitOperationsToMakeTwoIntegersEqual {

    public int minOperations(int n, int m) {
        if (isPrime(n)) return -1;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(p -> p[0]));
        minHeap.add(new int[] {n, n});
        Set<Integer> visited = new HashSet<>(Set.of(n));
        while (!minHeap.isEmpty()) {
            int[] poll = minHeap.poll();
            if (poll[1] == m) {
                return poll[0];
            }
            StringBuilder copy = new StringBuilder(String.valueOf(poll[1]));
            for (int i = 0; i < copy.length(); i++) {
                int digit = copy.charAt(i) - '0';
                if (digit > 0 && (i != 0 || digit - 1 != 0)) {
                    copy.setCharAt(i, Character.forDigit(digit - 1, 10));
                    int val = Integer.parseInt(copy.toString());
                    if (!isPrime(val) && !visited.contains(val)) {
                        visited.add(val);
                        minHeap.add(new int[] {poll[0] + val, val});
                    }
                    copy.setCharAt(i, Character.forDigit(digit, 10));
                }
                if (digit < 9) {
                    copy.setCharAt(i, Character.forDigit(digit + 1, 10));
                    int val = Integer.parseInt(copy.toString());
                    if (!isPrime(val) && !visited.contains(val)) {
                        visited.add(val);
                        minHeap.add(new int[] {poll[0] + val, val});
                    }
                    copy.setCharAt(i, Character.forDigit(digit, 10));
                }
            }
        }
        return -1;
    }

    boolean isPrime(int n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

}
