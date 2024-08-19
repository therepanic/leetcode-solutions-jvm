package twoKeysKeyboard;

public class TwoKeysKeyboard {
    public static int minSteps(int n) {
        if (n == 1) {
            return 0;
        }

        int[] answer = new int[1];
        answer[0] = Integer.MAX_VALUE;

        helper(answer, n, 1, 1, 1);

        return answer[0];
    }

    public static void helper(int[] answer, int n, int currentN, int buffer, int operation) {
        if (currentN > n) {
            return;
        }

        if (currentN == n) {
            answer[0] = Math.min(answer[0], operation);
        }

        helper(answer, n, currentN + buffer, buffer, operation + 1);

        helper(answer, n, currentN + currentN, currentN, operation + 2);
    }
}
