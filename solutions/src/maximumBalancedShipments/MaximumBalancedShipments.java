package maximumBalancedShipments;

public class MaximumBalancedShipments {
    public int maxBalancedShipments(int[] weight) {
        int max = -1;
        int c = 0;
        for (int i = 0; i < weight.length; i++) {
            if (weight[i] >= max) {
                max = weight[i];
            } else {
                c++;
                max = -1;
            }
        }
        return c;
    }
}
