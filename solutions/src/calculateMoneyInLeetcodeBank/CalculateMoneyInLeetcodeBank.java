package calculateMoneyInLeetcodeBank;

public class CalculateMoneyInLeetcodeBank {
    public int totalMoney(int n) {
        int ans = 0;
        int day = 1;
        while (n > 0) {
            for (int i = 0; i < Math.min(n, 7); i++) {
                ans += day + i;
            }
            n -= 7;
            day++;
        }
        return ans;
    }
}
