package checkIfWordCanBePlacedInCrossword;

public class CheckIfWordCanBePlacedInCrossword {
    public boolean placeWordInCrossword(char[][] board, String word) {
        char[] chars = word.toCharArray();
        for (int i = 0 ; i < board.length; i++) {
            int startI = 0;
            boolean skip = false;
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '#') {
                    if (startI == chars.length) {
                        return true;
                    }
                    startI = 0;
                    skip = false;
                } else if (board[i][j] == ' ') {
                    if (skip) continue;
                    startI++;
                    if (startI > chars.length) {
                        skip = true;
                        startI = 0;
                    }
                } else if (startI < chars.length && board[i][j] == chars[startI]) {
                    if (skip) continue;
                    startI++;
                } else if (startI < chars.length && board[i][j] != chars[startI]) {
                    if (skip) continue;
                    skip = true;
                    startI = 0;
                } else if (startI >= chars.length) {
                    if (skip) continue;
                    skip = true;
                    startI = 0;
                }
            }
            if (startI == chars.length) {
                return true;
            }
            startI = 0;
            skip = false;
            for (int j = board[i].length - 1; j >= 0; j--) {
                if (board[i][j] == '#') {
                    if (startI == chars.length) {
                        return true;
                    }
                    startI = 0;
                    skip = false;
                } else if (board[i][j] == ' ') {
                    if (skip) continue;
                    startI++;
                    if (startI > chars.length) {
                        skip = true;
                        startI = 0;
                    }
                } else if (startI < chars.length && board[i][j] == chars[startI]) {
                    if (skip) continue;
                    startI++;
                } else if (startI < chars.length && board[i][j] != chars[startI]) {
                    if (skip) continue;
                    skip = true;
                    startI = 0;
                } else if (startI >= chars.length) {
                    if (skip) continue;
                    skip = true;
                    startI = 0;
                }
            }
            if (startI == chars.length) {
                return true;
            }
        }
        for (int j = 0 ; j < board[0].length; j++) {
            int startI = 0;
            boolean skip = false;
            for (int i = 0; i < board.length; i++) {
                if (board[i][j] == '#') {
                    if (startI == chars.length) {
                        return true;
                    }
                    startI = 0;
                    skip = false;
                } else if (board[i][j] == ' ') {
                    if (skip) continue;
                    startI++;
                    if (startI > chars.length) {
                        skip = true;
                        startI = 0;
                    }
                } else if (startI < chars.length && board[i][j] == chars[startI]) {
                    if (skip) continue;
                    startI++;
                } else if (startI < chars.length && board[i][j] != chars[startI]) {
                    if (skip) continue;
                    skip = true;
                    startI = 0;
                } else if (startI >= chars.length) {
                    if (skip) continue;
                    skip = true;
                    startI = 0;
                }
            }
            if (startI == chars.length) {
                return true;
            }
            startI = 0;
            skip = false;
            for (int i = board.length - 1; i >= 0; i--) {
                if (board[i][j] == '#') {
                    if (startI == chars.length) {
                        return true;
                    }
                    startI = 0;
                    skip = false;
                } else if (board[i][j] == ' ') {
                    if (skip) continue;
                    startI++;
                    if (startI > chars.length) {
                        skip = true;
                        startI = 0;
                    }
                } else if (startI < chars.length && board[i][j] == chars[startI]) {
                    if (skip) continue;
                    startI++;
                } else if (startI < chars.length && board[i][j] != chars[startI]) {
                    if (skip) continue;
                    skip = true;
                    startI = 0;
                } else if (startI >= chars.length) {
                    if (skip) continue;
                    skip = true;
                    startI = 0;
                }
            }
            if (startI == chars.length) {
                return true;
            }
        }
        return false;
    }
}
