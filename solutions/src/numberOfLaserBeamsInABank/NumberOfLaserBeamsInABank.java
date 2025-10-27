package numberOfLaserBeamsInABank;

public class NumberOfLaserBeamsInABank {
    public int numberOfBeams(String[] bank) {
        int prev = 0, ans = 0;
        for (int i = 0; i < bank.length; i++) {
            int c = 0;
            for (int j = 0; j < bank[i].length(); j++) {
                if (bank[i].charAt(j) == '1') {
                    c++;
                }
            }
            if (c != 0) {
                ans += (prev * c);
                prev = c;
            }
        }
        return ans;
    }
}
