package fourDivisors;

public class FourDivisors {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += (fourDivisorsSum(num));
        }
        return sum;
    }

    public int fourDivisorsSum(int v) {
        int count = 0;
        int sum = 0;
        for (int i = 1; i * i <= v; i++) {
            if (v % i == 0) {
                int d1 = i;
                int d2 = v / i;
                if (d1 == d2) {
                    count++;
                    sum += d1;
                } else {
                    count += 2;
                    sum += d1 + d2;
                }
                if (count > 4) {
                    return 0;
                }
            }
        }
        return count != 4 ? 0 : sum;
    }
}
