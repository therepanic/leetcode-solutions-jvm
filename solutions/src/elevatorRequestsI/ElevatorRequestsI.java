package elevatorRequestsI;

public class ElevatorRequestsI {
    public int elevatorRequests(int n, int[] requests) {
        int floor = 0;
        int c = 0;
        for (int request : requests) {
            c += Math.abs(floor - request);
            floor = request;
        }
        return c;
    }
}
