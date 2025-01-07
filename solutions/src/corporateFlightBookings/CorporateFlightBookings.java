package corporateFlightBookings;

public class CorporateFlightBookings {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] prefix = new int[n];
        for (int[] booking : bookings) {
            prefix[--booking[0]] += booking[2];
            if (booking[1] < prefix.length) {
                prefix[booking[1]] -= booking[2];
            }
        }
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] += prefix[i - 1];
        }
        return prefix;
    }
}
