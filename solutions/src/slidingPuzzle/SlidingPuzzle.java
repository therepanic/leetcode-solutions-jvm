package slidingPuzzle;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class SlidingPuzzle {
    public static int slidingPuzzle(int[][] board) {
        StringBuilder curResult = new StringBuilder();

        Queue<Pair<String, Integer>> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();

         for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                curResult.append(board[i][j]);
            }
         }

         if (curResult.toString().equals("123450")) return 0;

         int[][] directions = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

         queue.add(new Pair<>(curResult.toString(), 0));

         while (!queue.isEmpty()) {
            Pair<String, Integer> pair = queue.poll();

            String first = pair.first;

            visited.add(first);

            int zeroIndex = first.indexOf('0');
            int row = zeroIndex / 3;
            int column = zeroIndex % 3;

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newColumn = column + dir[1];

                if (newRow >= 0 && newColumn >= 0 && newRow < 2 && newColumn < 3) {
                    int index = newRow * 3 + newColumn;

                    String newStr = swap(first, zeroIndex, index);
                    if (newStr.equals("123450")) return pair.second + 1;
                    if (visited.contains(newStr)) continue;

                    queue.add(new Pair<>(newStr, pair.second + 1));
                }
            }
        }

         return -1;
    }

    public static String swap(String str, int i, int j) {
        char[] strChars = str.toCharArray();

        char temp = strChars[i];
        strChars[i] = strChars[j];
        strChars[j] = temp;
        return String.valueOf(strChars);
    }

    public static class Pair<T, D> {
        public T first;
        public D second;

        public Pair(T first, D second) {
            this.first = first;
            this.second = second;
        }
    }
}
