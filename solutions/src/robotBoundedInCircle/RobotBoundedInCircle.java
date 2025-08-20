package robotBoundedInCircle;

public class RobotBoundedInCircle {
    public boolean isRobotBounded(String instructions) {
        instructions = instructions.repeat(4);
        char side = 'R';
        int row = 0;
        int col = 0;
        for (char c : instructions.toCharArray()) {
            if (c == 'G') {
                if (side == 'L') {
                    col--;
                } else if (side == 'R') {
                    col++;
                } else if (side == 'U') {
                    row--;
                } else if (side == 'D') {
                    row++;
                }
            } else {
                side = turn(side, c);
            }
        }
        return row == 0 && col == 0;
    }

    public char turn(char side, char deg) {
        if (side == 'R') {
            if (deg == 'L') {
                return 'U';
            } else if (deg == 'R') {
                return 'D';
            }
        } else if (side == 'D') {
            if (deg == 'L') {
                return 'R';
            } else if (deg == 'R') {
                return 'L';
            }
        } else if (side == 'L') {
            if (deg == 'L') {
                return 'D';
            } else if (deg == 'R') {
                return 'U';
            }
        } else if (side == 'U') {
            if (deg == 'L') {
                return 'L';
            } else if (deg == 'R') {
                return 'R';
            }
        }
        return ' ';
    }
}
