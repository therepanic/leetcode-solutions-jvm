package findTheHighestAltitude;

public class FindTheHighestAltitude {
    public int largestAltitude(int[] gain) {
        int max = 0;
        int a = 0;
        for (int i = 0; i < gain.length; i++) {
            a += gain[i];
            max = Math.max(max, a);
        }
        return max;
    }
}
