package relativeRanks;

import java.util.PriorityQueue;

public class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        String[] answer = new String[score.length];
        PriorityQueue<int[]> heap = new PriorityQueue<>((p1, p2) -> Integer.compare(p2[0], p1[0]));
        for (int i = 0; i < score.length; i++) {
            heap.add(new int[] {score[i], i});
        }
        int c = 1;
        while (!heap.isEmpty()) {
            int[] poll = heap.poll();
            switch (c) {
                case 1 -> answer[poll[1]] = "Gold Medal";
                case 2 -> answer[poll[1]] = "Silver Medal";
                case 3 -> answer[poll[1]] = "Bronze Medal";
                default -> answer[poll[1]] = String.valueOf(c);
            }
            c++;
        }
        return answer;
    }
}
