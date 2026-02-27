package minimumNumberOfCoinsToBeAdded;

import java.util.Arrays;

public class MinimumNumberOfCoinsToBeAdded {
    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int toAdd = 0;
        int sum = 0;
        int index = 0;
        while (sum < target) {
            if (index < coins.length && coins[index] <= sum + 1) {
                sum += coins[index];
                index++;
            } else {
                sum += sum + 1;
                toAdd++;
            }
        }
        return toAdd;
    }
}
