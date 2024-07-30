package nQueens2;

import java.util.HashMap;
import java.util.Map;

public class NQueens2 {
    public static int totalNQueens(int n) {
        int[] answer = new int[1];
        int[][] desc = new int[n][n];

        check(answer, desc, 0, new HashMap<>());

        return answer[0];
    }

    private static void check(int[] answer, int[][] desc, int position, Map<Integer, Integer> positions) {
        firstLoop: for (int i = 0; i < desc[position].length; i++) {
            desc[position][i] = 1;
            positions.put(position, i);

            for (int j = position - 1; j >= 0; j--) {
                if (positions.get(j) == i) {
                    desc[position][i] = 0;
                    positions.remove(position);
                    continue firstLoop;
                }
            }

            int copyPosition = position - 1;
            int copyI = i - 1;

            while (copyPosition >= 0 && copyPosition < desc.length && copyI >= 0 && copyI < desc.length) {
                if (desc[copyPosition][copyI] == 1) {
                    desc[position][i] = 0;
                    positions.remove(position);
                    continue firstLoop;
                }

                copyPosition--;
                copyI--;
            }

            copyPosition = position - 1;
            copyI = i + 1;

            while (copyPosition >= 0 && copyPosition < desc.length && copyI >= 0 && copyI < desc.length) {
                if (desc[copyPosition][copyI] == 1) {
                    desc[position][i] = 0;
                    positions.remove(position);
                    continue firstLoop;
                }

                copyPosition--;
                copyI++;
            }

            if (position != desc.length - 1) {
                check(answer, desc, position + 1, positions);
            } else {
                answer[0]++;
            }

            desc[position][i] = 0;
            positions.remove(position);
        }
    }
}
