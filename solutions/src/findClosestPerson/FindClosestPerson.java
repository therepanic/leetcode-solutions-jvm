package findClosestPerson;

public class FindClosestPerson {
    public int findClosest(int x, int y, int z) {
        int a = Math.abs(z - x);
        int b = Math.abs(z - y);
        if (a == b) {
            return 0;
        } else if (a > b) {
            return a;
        } else {
            return b;
        }
    }
}
