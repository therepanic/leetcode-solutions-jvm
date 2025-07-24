package sortTheStudentsByTheirKthScore;

import java.util.Arrays;

public class SortTheStudentsByTheirKthScore {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score, (p1, p2) -> p2[k] - p1[k]);
        return score;
    }
}
