package minimumInsertionsToBalanceAParenthesesString;

public class MinimumInsertionsToBalanceAParenthesesString {
    public static int minInsertions(String s) {
        int insertions = 0;
        int open = 0;
        int close = 0;
        boolean closeBeen = false;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                if (closeBeen) {
                    int pairs = close / 2;
                    if (open >= pairs) {
                        open -= pairs;
                    } else {
                        insertions += (pairs - open);
                        open = 0;
                    }
                    if (close % 2 == 1) {
                        if (open > 0) {
                            open--;
                            insertions += 1;
                        } else {
                            insertions += 2;
                        }
                    }
                    closeBeen = false;
                    close = 0;
                }
                open++;
            } else if (c == ')') {
                closeBeen = true;
                close++;
            }
        }
        if (closeBeen) {
            int pairs = close / 2;
            if (open >= pairs) {
                open -= pairs;
            } else {
                insertions += (pairs - open);
                open = 0;
            }
            if (close % 2 == 1) {
                if (open > 0) {
                    open--;
                    insertions += 1;
                } else {
                    insertions += 2;
                }
            }
        }
        insertions += open * 2;
        return insertions;
    }
}
