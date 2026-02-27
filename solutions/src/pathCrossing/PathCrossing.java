package pathCrossing;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PathCrossing {
    public boolean isPathCrossing(String path) {
        Set<List<Integer>> pathes = new HashSet<>(Set.of(List.of(0, 0)));
        int x = 0;
        int y  = 0;
        for (int i = 0; i < path.length(); i++) {
            char ch = path.charAt(i);
            if (ch == 'N') {
                x++;
            } else if (ch == 'S') {
                x--;
            } else if (ch == 'E') {
                y++;
            } else if (ch == 'W') {
                y--;
            }
            List<Integer> of = List.of(x, y);
            if (!pathes.add(of)) {
                return true;
            }
        }
        return false;
    }
}
