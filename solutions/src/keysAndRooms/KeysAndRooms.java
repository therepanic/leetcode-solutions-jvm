package keysAndRooms;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeysAndRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] canVisit = new boolean[rooms.size()];
        canVisit[0] = true;

        helper(rooms, canVisit, new HashSet<>(), 0);

        for (boolean b : canVisit) {
            if (!b) {
                return false;
            }
        }

        return true;
    }

    public void helper(List<List<Integer>> rooms, boolean[] canVisit, Set<Integer> visited, int roomIndex) {
        for (int room : rooms.get(roomIndex)) {
            if (!visited.contains(room)) {
                visited.add(room);
                canVisit[room] = true;

                helper(rooms, canVisit, visited, room);
            }
        }
    }
}
