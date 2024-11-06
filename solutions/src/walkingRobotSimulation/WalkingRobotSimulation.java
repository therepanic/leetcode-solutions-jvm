package walkingRobotSimulation;

import java.util.HashSet;
import java.util.Set;

public class WalkingRobotSimulation {
    public int robotSim(int[] commands, int[][] obstacles) {
        char side = 'r';

        Set<String> obstacleSet = new HashSet<>();

        for (int[] obstacle : obstacles) {
            obstacleSet.add(obstacle[0] + "-" + obstacle[1]);
        }

        int max = 0;

        int row = 0;
        int column = 0;

        for (int command : commands) {
            switch (side) {
                case 'r' -> {
                    if (command == -1) {
                        side = 'd';
                    } else if (command == -2) {
                        side = 'u';
                    } else {
                        for (int i = 0; i < command; i++) {
                            String key = row + "-" + (column + 1);

                            if (obstacleSet.contains(key)) {
                                break;
                            }

                            column++;
                            max = Math.max(max, row * row + column * column);
                        }
                    }
                }
                case 'd' -> {
                    if (command == -1) {
                        side = 'l';
                    } else if (command == -2) {
                        side = 'r';
                    } else {
                        for (int i = 0; i < command; i++) {
                            String key = (row + 1) + "-" + column;

                            if (obstacleSet.contains(key)) {
                                break;
                            }

                            row++;
                            max = Math.max(max, row * row + column * column);
                        }
                    }
                }
                case 'l' -> {
                    if (command == -1) {
                        side = 'u';
                    } else if (command == -2) {
                        side = 'd';
                    } else {
                        for (int i = 0; i < command; i++) {
                            String key = row + "-" + (column - 1);

                            if (obstacleSet.contains(key)) {
                                break;
                            }

                            column--;
                            max = Math.max(max, row * row + column * column);
                        }
                    }
                }
                case 'u' -> {
                    if (command == -1) {
                        side = 'r';
                    } else if (command == -2) {
                        side = 'l';
                    } else {
                        for (int i = 0; i < command; i++) {
                            String key = (row - 1) + "-" + column;

                            if (obstacleSet.contains(key)) {
                                break;
                            }

                            row--;
                            max = Math.max(max, row * row + column * column);
                        }
                    }
                }
            }
        }
        return max;
    }
}
