package scoreOfParentheses;

public class ScoreOfParentheses {
    public int scoreOfParentheses(String s) {
        return dfs(s, 0, s.length());
    }

    private int dfs(String s, int left, int right) {
        int score = 0;
        int balance = 0;

        for (int i = left; i < right; i++) {
            if (s.charAt(i) == '(') {
                balance++;
            } else {
                balance--;
                if (balance == 0) {
                    if (i - left == 1) {
                        score += 1;
                    } else {
                        score += 2 * dfs(s, left + 1, i);
                    }
                    left = i + 1;
                }
            }
        }
        return score;
    }
}
