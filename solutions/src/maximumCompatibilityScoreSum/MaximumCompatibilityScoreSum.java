package maximumCompatibilityScoreSum;

public class MaximumCompatibilityScoreSum {

    public void helper(int[] ans, int[][] students, int[][] mentors, int maskB, int pos, int s) {
        if (pos == students.length) {
            ans[0] = Math.max(ans[0], s);
            return;
        }
        for (int j = 0; j < mentors.length; j++) {
            if ((maskB & (1 << j)) == 0) {
                int score = 0;
                for (int it = 0; it < students[0].length; it++) {
                    score += students[pos][it] == mentors[j][it] ? 1 : 0;
                }
                helper(ans, students, mentors, maskB ^ (1 << j), pos + 1, s + score);
            }
        }
    }

    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int[] ans = new int[1];
        helper(ans, students, mentors,0, 0, 0);
        return ans[0];
    }
}
