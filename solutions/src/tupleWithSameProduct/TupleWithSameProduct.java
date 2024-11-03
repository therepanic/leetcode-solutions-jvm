package tupleWithSameProduct;

import java.util.HashMap;
import java.util.Map;

public class TupleWithSameProduct {
    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> productCountMap = new HashMap<>();

        int c = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i == j) continue;

                int product = nums[i] * nums[j];

                if (productCountMap.containsKey(product)) {
                    productCountMap.put(product, productCountMap.get(product) + 1);
                } else {
                    productCountMap.put(product, 1);
                }
            }
        }

        for (int value : productCountMap.values()) {
            if (value % 2 == 0) {
                c += (value - 2) * value;
            }
        }

        return c;
    }
}
