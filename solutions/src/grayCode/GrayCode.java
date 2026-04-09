package grayCode;

import java.util.ArrayList;
import java.util.List;

public class GrayCode {
    public List<Integer> grayCode(int n) {
        List<Integer> nums = new ArrayList<>();
        int value = 1 << n;
        for (int i = 0; i < value; i++) {
            nums.add(i ^ (i >> 1));
        }
        return nums;
    }
}
