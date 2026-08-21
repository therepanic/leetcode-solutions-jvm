package singleNumberII;

public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int[] c = new int[32];
        for (int i = 0; i < 32; i++) {
            for (int v : nums) {
                if ((v & (1 << i)) != 0) {
                    c[i]++;
                }
            }
        }
        int a = 0;
        for (int i = 0; i < 32; i++) {
            if (c[i] % 3 == 1) {
                a |= 1 << i;
            }
        }
        return a;
    }
}
