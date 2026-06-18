package angleBetweenHandsOfAClock;

public class AngleBetweenHandsOfAClock {
    public double angleClock(int hour, int minutes) {
        double m = minutes * 6;
        double h = (hour * 30) + (minutes * 0.5);
        double ans = Math.abs(m - h);
        return ans > 180 ? 360 - ans : ans;
    }
}
