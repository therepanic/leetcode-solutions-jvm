package arrayNesting;

public class ArrayNesting {
    public int arrayNesting(int[] nums) {
        int c = 0;
        boolean[] checked = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int j = nums[i];
            int count = 0;
            while (!checked[j]) {
                checked[j] = true;
                j = nums[j];
                count++;
            }
            c = Math.max(c, count);
        }
        return c;
    }
}
