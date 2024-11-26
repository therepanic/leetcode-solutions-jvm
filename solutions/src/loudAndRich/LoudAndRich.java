package loudAndRich;

import java.util.*;

public class LoudAndRich {
    public static int[] loudAndRich(int[][] richer, int[] quiet) {
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < quiet.length; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] rich : richer) {
            graph.get(rich[1]).add(rich[0]);
        }

        int[] answer = new int[quiet.length];
        Arrays.fill(answer, -1);

        for (int i = 0; i < quiet.length; i++) {
            bypass(i, graph, answer, quiet);
        }

        return answer;
    }

    public static int bypass(int node, List<List<Integer>> graph, int[] answer, int[] quiet) {
        if (answer[node] != -1) {
            return answer[node];
        }
        answer[node] = node;

        for (int nod : graph.get(node)) {
            int res = bypass(nod, graph, answer, quiet);
            if (quiet[res] < quiet[answer[node]]) {
                answer[node] = res;
            }
        }

        return answer[node];
    }
}
