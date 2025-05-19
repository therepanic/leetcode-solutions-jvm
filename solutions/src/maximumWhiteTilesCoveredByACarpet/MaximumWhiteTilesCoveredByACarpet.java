package maximumWhiteTilesCoveredByACarpet;

import java.util.Arrays;

public class MaximumWhiteTilesCoveredByACarpet {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, (p1, p2) -> {
            if (p1[0] == p2[0]) {
                return Integer.compare(p1[1], p2[1]);
            } else {
                return Integer.compare(p1[0], p2[0]);
            }
        });
        int answer = 0;
        int c = 0;
        int it = 0;
        for (int i = 0; i < tiles.length; i++) {
            int start = tiles[i][0];
            int end = start + carpetLen - 1;
            while (it < tiles.length && end >= tiles[it][1]) {
                c += tiles[it][1] - tiles[it][0] + 1;
                it++;
            }
            if (it < tiles.length) {
                answer = Math.max(answer, c + Math.max(0, end - tiles[it][0] + 1));
            } else if (it == tiles.length) {
                answer = Math.max(answer, c);
            }
            c -= tiles[i][1] - tiles[i][0] + 1;
        }
        return answer;
    }
}
