package majorityElement;

public class MajorityElement {
    public static int majorityElement(int[] nums) {
        int num = 0;
        int count = 0;

        for (int i : nums) {
            if (i == num && count >= 0) {
                count++;
            } else if (i != num && count > 0) {
                count--;
            } else if (i != num && count == 0) {
                num = i;
                count++;
            }
        }

        return num;
    }
}
