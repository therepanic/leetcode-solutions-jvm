package lemonadeChange;

public class LemonadeChange {
    public boolean lemonadeChange(int[] bills) {
        int five = 0;
        int ten = 0;
        int twenty = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5) {
                five++;
            } else if (bills[i] == 10) {
                if (five == 0) {
                    return false;
                }
                five--;
                ten++;
            } else if (bills[i] == 20) {
                if (ten >= 1 && five >= 1) {
                    five--;
                    ten--;
                } else if (five >= 3) {
                    five -= 3;
                }  else {
                    return false;
                }
            }
        }
        return true;
    }
}
