package checkIfGridCanBeCutIntoSections;

import java.util.Arrays;
import java.util.Comparator;

public class CheckIfGridCanBeCutIntoSections {
    public static boolean checkValidCuts(int n, int[][] rectangles) {
        Arrays.sort(rectangles, Comparator.comparingInt(p -> p[0]));
        int c = 0;
        int perm = rectangles[0][2];
        for (int i = 1; i < rectangles.length; i++) {
            if (rectangles[i][0] >= perm) {
                c++;
                if (c == 2) return true;
            }
            perm = Math.max(perm, rectangles[i][2]);
        }

        c = 0;
        Arrays.sort(rectangles, Comparator.comparingInt(p -> p[1]));
        perm = rectangles[0][3];
        for (int i = 1; i < rectangles.length; i++) {
            if (rectangles[i][1] >= perm) {
                c++;
                if (c == 2) return true;
            }
            perm = Math.max(perm, rectangles[i][3]);
        }
        return false;
    }
}
