package countZeroRequestServers;

import java.util.*;

public class CountZeroRequestServers {

    public static int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs, Comparator.comparingInt(p -> p[1]));
        int[][] newQueries = new int[queries.length][2];
        for (int i = 0; i < queries.length; i++) {
            newQueries[i] = new int[] {i, queries[i]};
        }
        Arrays.sort(newQueries, Comparator.comparingInt(p -> p[1]));
        Map<Integer, Integer> uniqServers = new HashMap<>();
        int l = 0;
        int it = 0;
        int[] answer = new int[newQueries.length];
        Arrays.fill(answer, n);
        int r = 0;
        while (r < logs.length && it < newQueries.length) {
            while (newQueries[it][1] - x > logs[l][1] && l < r) {
                uniqServers.compute(logs[l][0], (key, val) -> val.equals(1) ? null : val - 1);
                l++;
            }
            if (logs[r][1] > newQueries[it][1]) {
                answer[newQueries[it][0]] = n - uniqServers.size();
                it++;
                continue;
            }
            uniqServers.put(logs[r][0], uniqServers.getOrDefault(logs[r][0], 0) + 1);
            r++;
        }
        while (it < newQueries.length && l < logs.length) {
            while (l < logs.length && newQueries[it][1] - x > logs[l][1]) {
                uniqServers.compute(logs[l][0], (key, val) -> val.equals(1) ? null : val - 1);
                l++;
            }
            if (logs[r - 1][1] <= newQueries[it][1]) {
                answer[newQueries[it][0]] = n - uniqServers.size();
                it++;
            } else {
                break;
            }
        }
        return answer;
    }

}
