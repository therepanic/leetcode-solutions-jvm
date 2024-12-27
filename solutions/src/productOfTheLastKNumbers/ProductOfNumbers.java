package productOfTheLastKNumbers;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {
    private final List<Integer> nums;
    private int oneCount = 0;
    private int zeroIndex = -1;
    public ProductOfNumbers() {
        this.nums = new ArrayList<>();
    }

    public void add(int num) {
        nums.add(num);
        if (num == 1) {
            oneCount++;
        } else if (num == 0) {
            zeroIndex = nums.size() - 1;
        }
    }

    public int getProduct(int k) {
        if (oneCount == nums.size()) return 1;
        if (zeroIndex >= nums.size() - k) return 0;
        int product = nums.getLast();

        for (int i = nums.size() - 2; i >= nums.size() - k; i--) {
            product *= nums.get(i);
        }
        return product;
    }
}
