package solvingQuestionsWithBrainpower;

public class SolvingQuestionsWithBrainpower {

    public static long mostPoints(int[][] questions) {
        long[] memo = new long[questions.length];
        memo[memo.length - 1] = questions[questions.length - 1][0];
        for (int i = questions.length - 2; i >= 0; i--) {
            memo[i] = Math.max(questions[i][0] + (i + questions[i][1] + 1 < questions.length ? (memo[i + questions[i][1] + 1]) : 0), memo[i + 1]);
        }
        return memo[0];
    }
}
