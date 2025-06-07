package floodFill;

import java.util.ArrayDeque;
import java.util.Queue;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<int[]> fill = new ArrayDeque<>();
        int itColor = image[sr][sc];
        fill.add(new int[] {sr, sc});
        int[][] dir = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!fill.isEmpty()) {
            int[] poll = fill.poll();
            image[poll[0]][poll[1]] = color;
            for (int[] d : dir) {
                int x = poll[0] + d[0];
                int y = poll[1] + d[1];
                if (x < 0 || y < 0 || x >= image.length || y >= image[0].length || image[x][y] != itColor || image[x][y] == color) {
                    continue;
                }
                fill.add(new int[] {x, y});
            }
        }
        return image;
    }

}
