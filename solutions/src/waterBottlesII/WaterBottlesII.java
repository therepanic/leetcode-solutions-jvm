package waterBottlesII;

public class WaterBottlesII {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles - numExchange >= 0) {
            ans++;
            numBottles -= numExchange - 1;
            numExchange++;
        }
        return ans;
    }
}
