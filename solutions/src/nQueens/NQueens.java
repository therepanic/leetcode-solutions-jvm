package nQueens;

import java.util.*;

public class NQueens {
    public static List<List<String>> solveNQueens(int n) {
        int[][] desc = new int[n][n];
        List<int[][]> answerList = new ArrayList<>();

        check(answerList, desc, 0, new HashMap<>());

        List<List<String>> answer = new ArrayList<>();
        StringBuilder answerBuilder = new StringBuilder();

        for (int[][] a1 : answerList) {
            List<String> subAnswer = new ArrayList<>();
            for (int[] a2 : a1) {
                for (int value : a2) {
                    if (value == 0) {
                        answerBuilder.append(".");
                    } else {
                        answerBuilder.append("Q");
                    }
                }
                subAnswer.add(answerBuilder.toString());
                answerBuilder.delete(0, answerBuilder.length());
            }

            answer.add(subAnswer);
        }

        return answer;
    }

    private static void check(List<int[][]> answer, int[][] desc, int position, Map<Integer, Integer> positions) {
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
                int[][] answerArray = new int[desc[0].length][desc.length];

                for (int k = 0; k < desc.length; k++) {
                    answerArray[k] = desc[k].clone();
                }

                answer.add(answerArray);
            }

            desc[position][i] = 0;
            positions.remove(position);
        }
    }
}
