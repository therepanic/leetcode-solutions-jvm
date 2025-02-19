package countCollisionsOnARoad;

public class CountCollisionsOnARoad {
    public static int countCollisions(String directions) {
        char[] dirs = directions.toCharArray();
        int i = 0;
        int j = directions.length() - 1;
        for (int it = 0; i < directions.length(); it++) {
            if (dirs[it] == 'L') {
                i++;
            } else {
                break;
            }
        }
        for (int it = directions.length() - 1; it >= 0; it--) {
            if (dirs[it] == 'R') {
                j--;
            } else {
                break;
            }
        }
        int c = 0;
        for (int it = i; it <= j; it++) {
            if (dirs[it] != 'S') {
                c++;
            }
        }
        return c;
    }
}
