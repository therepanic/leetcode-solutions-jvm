package executionOfAllSuffixInstructionsStayingInAGrid;

public class ExecutionOfAllSuffixInstructionsStayingInAGrid {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int a = s.length();
        int[] ans = new int[a];
        for (int i = 0; i < a; i++) {
            int x = startPos[0];
            int y = startPos[1];
            int c = 0;
            for (int j = i; j < a; j++) {
                char ch = s.charAt(j);
                if (ch == 'L') {
                    y--;
                } else if (ch == 'R') {
                    y++;
                } else if (ch == 'U') {
                    x--;
                } else {
                    x++;
                }
                if (x < 0 || y < 0 || x >= n || y >= n) {
                    break;
                }
                c++;
            }
            ans[i] = c;
        }
        return ans;
    }
}
