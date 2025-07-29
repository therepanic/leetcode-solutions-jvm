package destroyingAsteroids;

import java.util.Arrays;

public class DestroyingAsteroids {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long massC = mass;
        Arrays.sort(asteroids);
        for (int asteroid : asteroids) {
            if (massC < asteroid) {
                return false;
            }
            massC += asteroid;
        }
        return true;
    }
}
