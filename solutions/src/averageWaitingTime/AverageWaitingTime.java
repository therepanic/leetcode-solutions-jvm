package averageWaitingTime;

public class AverageWaitingTime {
    public static double averageWaitingTime(int[][] customers) {
        long sum = customers[0][1];
        long curSum = customers[0][0] + customers[0][1];
        for (int i = 1; i < customers.length; i++) {
            int[] customer = customers[i];
            if (curSum < customer[0]) {
                curSum = customer[1] + customer[0];
                sum += curSum - customer[0];
            } else {
                curSum += customer[1];
                sum += curSum - customer[0];
            }
        }
        return (double) sum / customers.length;
    }
}
