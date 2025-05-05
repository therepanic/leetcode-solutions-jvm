package robotCollisions;

import java.util.*;

public class RobotCollisions {
    public static List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int[][] robots = new int[positions.length][4];
        for (int i = 0; i < positions.length; i++) {
            robots[i][0] = positions[i];
            robots[i][1] = healths[i];
            char sym = directions.charAt(i);
            robots[i][2] = sym == 'L' ? 0 : 1;
            robots[i][3] = i;
        }
        Arrays.sort(robots, Comparator.comparingInt(p -> p[0]));
        Deque<int[]> robotsStack = new ArrayDeque<>();
        for (int[] robot : robots) {
            if (robot[2] == 1) {
                robotsStack.add(robot);
            } else {
                while (!robotsStack.isEmpty() && robotsStack.getLast()[2] == 1 && robot[1] > 0) {
                    if (robotsStack.getLast()[1] == robot[1]) {
                        robotsStack.pollLast();
                        robot = null;
                        break;
                    } else if (robotsStack.getLast()[1] > robot[1]) {
                        robotsStack.getLast()[1]--;
                        robot = null;
                        break;
                    } else {
                        robot[1]--;
                        robotsStack.pollLast();
                    }
                }
                if (robot != null) {
                    robotsStack.addLast(robot);
                }
            }
        }
        List<int[]> preAnswer = new ArrayList<>(robotsStack);
        Collections.sort(preAnswer, Comparator.comparingInt(p -> p[3]));
        List<Integer> answer = new ArrayList<>();
        for (int[] entry : preAnswer) {
            answer.add(entry[1]);
        }
        return answer;
    }
}
