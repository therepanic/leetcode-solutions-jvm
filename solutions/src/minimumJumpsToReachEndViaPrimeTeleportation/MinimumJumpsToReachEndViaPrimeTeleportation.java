package minimumJumpsToReachEndViaPrimeTeleportation;

import java.util.*;

public class MinimumJumpsToReachEndViaPrimeTeleportation {
    public int minJumps(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        boolean[] primes = getPrimes(max + 1);
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int j = 0; j < nums.length; j++) {
            int x = nums[j];
            for (int d = 1; d * d <= x; d++) {
                if (x % d == 0) {
                    groups.computeIfAbsent(d, _ -> new ArrayList<>()).add(j);
                    if (d != x / d) {
                        groups.computeIfAbsent(x / d, _ -> new ArrayList<>()).add(j);
                    }
                }
            }
        }
        boolean[] visited = new boolean[nums.length];
        Queue<int[]> bfs = new ArrayDeque<>(List.of(new int[] {0, 0}));
        visited[0] = true;
        while (!bfs.isEmpty()) {
            int kz = bfs.size();
            for (int i = 0; i < kz && !bfs.isEmpty(); i++) {
                int[] poll = bfs.poll();
                if (poll[0] + 1 < nums.length && !visited[poll[0] + 1]) {
                    visited[poll[0] + 1] = true;
                    bfs.add(new int[]{poll[0] + 1, poll[1] + 1});
                }
                if (poll[0] - 1 >= 0 && !visited[poll[0] - 1]) {
                    visited[poll[0] - 1] = true;
                    bfs.add(new int[]{poll[0] - 1, poll[1] + 1});
                }
                if (poll[0] == nums.length - 1) {
                    return poll[1];
                }
                if (primes[nums[poll[0]]]) continue;
                for (int index : groups.getOrDefault(nums[poll[0]], Collections.emptyList())) {
                    if (visited[index]) continue;
                    visited[index] = true;
                    bfs.add(new int[] {index, poll[1] + 1});
                }
                groups.remove(nums[poll[0]]);
            }
        }
        return -1;
    }

    public static boolean[] getPrimes(int n) {
        if (n < 2) return new boolean[0];
        boolean[] isComposite = new boolean[n + 1];
        isComposite[0] = true;
        isComposite[1] = true;
        for (int p = 2; p * p <= n; p++) {
            if (!isComposite[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isComposite[i] = true;
                }
            }
        }
        return isComposite;
    }
}
