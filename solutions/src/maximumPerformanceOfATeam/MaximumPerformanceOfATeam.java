package maximumPerformanceOfATeam;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumPerformanceOfATeam {

    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] speff = new int[n][2];
        for (int i = 0; i < speff.length; i++) {
            speff[i] = new int[] {speed[i], efficiency[i]};
        }
        Arrays.sort(speff, (p1, p2) -> p2[1] - p1[1]);
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);
        long sum = 0;
        long answer = 0;
        for (int[] sp : speff) {
            sum += sp[0];
            heap.add(sp[0]);
            if (heap.size() > k) {
                sum -= heap.poll();
            }
            answer = Math.max(answer, sp[1] * sum);
        }
        return (int) (answer % (int) (1e9 + 7));
    }

}
