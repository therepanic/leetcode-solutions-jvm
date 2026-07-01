package richestCustomerWealth;

public class RichestCustomerWealth {
    public int maximumWealth(int[][] accounts) {
        int wealth = Integer.MIN_VALUE;
        for (int i = 0; i < accounts.length; i++) {
            int sum = 0;
            for (int j = 0; j < accounts[i].length; j++) {
                sum += accounts[i][j];
            }
            wealth = Math.max(sum, wealth);
        }
        return wealth;
    }
}
