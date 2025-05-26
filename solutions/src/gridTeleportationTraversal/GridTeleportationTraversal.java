package gridTeleportationTraversal;

import java.util.*;

public class GridTeleportationTraversal {

    public int minMoves(String[] matrix) {
        char[][] matrixChars = new char[matrix.length][matrix[0].length()];
        Map<Character, List<int[]>> portals = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length(); j++) {
                matrixChars[i][j] = Character.toLowerCase(matrix[i].charAt(j));
                if (Character.isLetter(matrixChars[i][j])) {
                    portals.computeIfAbsent(matrixChars[i][j], p -> new ArrayList<>()).add(new int[] {i, j});
                }
            }
        }
        Queue<int[]> bfs = new ArrayDeque<>();
        if (Character.isLetter(matrixChars[0][0])) {
            for (int[] portal : portals.get(matrixChars[0][0])) {
                matrixChars[portal[0]][portal[1]] = '!';
                bfs.add(new int[] {portal[0], portal[1]});
            }
        } else {
            matrixChars[0][0] = '!';
            bfs.add(new int[] {0, 0});
        }
        if (matrixChars[matrixChars.length - 1][matrixChars[0].length - 1] == '!') {
            return 0;
        }
        int answer = 1;
        int[][] dir = new int[][] {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        while (!bfs.isEmpty()) {
            int size = bfs.size();
            for (int i = 0; i < size; i++) {
                int[] poll = bfs.poll();
                for (int[] d : dir) {
                    int first = poll[0] + d[0];
                    int second = poll[1] + d[1];
                    if (first >= 0 && first < matrixChars.length && second >= 0 && second < matrixChars[0].length) {
                        if (matrixChars[first][second] == '.') {
                            matrixChars[first][second] = '!';
                            if (first == matrix.length - 1 && second == matrix[0].length() - 1) {
                                return answer;
                            }
                            bfs.add(new int[] {first, second});
                        } else if (Character.isLetter(matrixChars[first][second])) {
                            for (int[] portal : portals.get(matrixChars[first][second])) {
                                if (matrixChars[portal[0]][portal[1]] != '!') {
                                    matrixChars[portal[0]][portal[1]] = '!';
                                    if (portal[0] == matrix.length - 1 && portal[1] == matrix[0].length() - 1) {
                                        return answer;
                                    }
                                    bfs.add(new int[] {portal[0], portal[1]});
                                }
                            }
                        }
                    }
                }
            }
            answer++;
        }
        return -1;
    }

}
