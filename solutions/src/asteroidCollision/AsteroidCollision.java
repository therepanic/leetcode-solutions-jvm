package asteroidCollision;

import java.util.*;

public class AsteroidCollision {
    public int[] asteroidCollision(int[] asteroids) {
        int i = 0;

        Deque<Integer> stack = new ArrayDeque<>();


        while (i < asteroids.length) {
            int val = asteroids[i];

            if (stack.isEmpty()) {
                stack.addLast(val);
                i++;
            } else {
                if (val < 0 && stack.getLast() > 0) {
                    int abs = Math.abs(val);

                    if (abs > stack.getLast()) {
                        stack.removeLast();
                    } else if (abs < stack.getLast()) {
                        i++;
                    } else {
                        i++;
                        stack.removeLast();
                    }
                } else {
                    stack.addLast(val);
                    i++;
                }
            }
        }

        i = 0;
        int[] collision = new int[stack.size()];
        while (!stack.isEmpty()) {
            collision[i] = stack.pollFirst();
            i++;
        }

        return collision;
    }
}
