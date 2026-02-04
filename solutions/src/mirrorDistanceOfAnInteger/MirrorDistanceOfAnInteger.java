package mirrorDistanceOfAnInteger;

public class MirrorDistanceOfAnInteger {
    public int mirrorDistance(int n) {
        int copy = n;
        int reversed = 0;
        while (n != 0) {
            reversed *= 10;
            reversed += n % 10;
            n /= 10;
        }
        return Math.abs(copy - reversed);
    }
}
