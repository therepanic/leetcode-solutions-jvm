package countGoodMeals;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountGoodMeals {
    public int countPairs(int[] deliciousness) {
        List<Integer> values = new ArrayList<>(List.of(1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072, 262144, 524288, 1048576, 2097152));
        long ans = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int del : deliciousness) {
            for (int val : values) {
                int a = countMap.getOrDefault(val - del, 0);
                ans += a;
            }
            countMap.put(del, countMap.getOrDefault(del, 0) + 1);
        }
        return (int) (ans % 1_000_000_007);
    }
}
