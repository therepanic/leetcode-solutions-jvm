package alphabetBoardPath;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AlphabetBoardPath {

    public String alphabetBoardPath(String target) {
        List<List<Character>> matrix = new ArrayList<>(List.of(List.of('a', 'b', 'c', 'd', 'e'), List.of('f', 'g', 'h', 'i', 'j'),
                List.of('k', 'l', 'm', 'n', 'o'), List.of('p', 'q', 'r', 's', 't'), List.of('u', 'v', 'w', 'x', 'y'),
                List.of('z')));
        int[][] charIndex = new int[26][2];
        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                charIndex[matrix.get(i).get(j) - 'a'] = new int[] {i, j};
            }
        }
        int moves = 0;
        StringBuilder sb = new StringBuilder();
        char[] chars = target.toCharArray();
        for (int i = 0; i < target.length(); i++) {
            if (i == 0) {
                sb.append(minPath(0, 0, 0, chars[i], matrix,
                        new boolean[matrix.size()][matrix.getFirst().size()]));
            } else {
                int[] coords = charIndex[chars[i - 1] - 'a'];
                sb.append(minPath(coords[0], coords[1], moves, chars[i], matrix,
                        new boolean[matrix.size()][matrix.getFirst().size()]));
            }
        }
        return sb.toString();
    }

    public String minPath(int m, int n, int moves, char need, List<List<Character>> matrix, boolean[][] checked) {
        Queue<Object[]> path = new ArrayDeque<>();
        path.add(new Object[] {m, n, moves, ""});
        int[][] dir = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        char[] a = new char[] {'D', 'R', 'U', 'L'};
        while (!path.isEmpty()) {
            Object[] poll = path.poll();
            int first = (int) poll[0];
            int sec = (int) poll[1];
            int move = (int) poll[2];
            String s = (String) poll[3];
            if (checked[first][sec]) continue;
            checked[first][sec] = true;
            if (matrix.get(first).get(sec) == need) {
                return s + "!";
            }
            for (int i = 0; i < dir.length; i++) {
                int[] d = dir[i];
                int x = first + d[0];
                int y = sec + d[1];
                if (x < 0 || x >= matrix.size() || y < 0 || y >= matrix.get(x).size() || checked[x][y]) {
                    continue;
                }
                path.add(new Object[] {x, y, move + 1, s + a[i]});
            }
        }
        return null;
    }

}
