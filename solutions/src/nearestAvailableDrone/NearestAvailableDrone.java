package nearestAvailableDrone;

public class NearestAvailableDrone {
    public int nearestDrone(int[][] drones, int[] target) {
        int id = -1;
        int dist = Integer.MAX_VALUE;
        for (int i = 0; i < drones.length; i++) {
            int[] drone = drones[i];
            int d = Math.abs(drone[0] - target[0]) + Math.abs(drone[1] - target[1]);
            if (d <= drone[2] && d < dist) {
                dist = d;
                id = i;
            }
        }
        return id;
    }
}
