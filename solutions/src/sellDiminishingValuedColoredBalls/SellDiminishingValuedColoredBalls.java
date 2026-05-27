package sellDiminishingValuedColoredBalls;

import java.util.Map;
import java.util.TreeMap;

public class SellDiminishingValuedColoredBalls {
    public int maxProfit(int[] inventory, int orders) {
        long sum = 0;
        TreeMap<Integer, Long> keyMap = new TreeMap<>(Map.of(0, 1L));
        int max = -1;
        for (int i = 0; i < inventory.length; i++) {
            keyMap.put(inventory[i], keyMap.getOrDefault(inventory[i], 0L) + 1);
            max = Math.max(inventory[i], max);
        }
        while (!keyMap.isEmpty() && orders != 0) {
            int a = keyMap.lowerKey(max);
            long count = keyMap.get(max);
            long balls = count * (max - a);
            if (orders >= balls) {
                orders -= balls;
                sum += count * (max + a + 1) * (max - a) / 2;
                keyMap.remove(max);
                keyMap.put(a, keyMap.getOrDefault(a, 0L) + count);
                max = a;
            } else {
                long fullLevels = orders / count;
                long rest = orders % count;
                long s = (max + (max - fullLevels + 1)) * fullLevels / 2;
                sum += count * s;
                sum += rest * (max - fullLevels);
                break;
            }
        }
        return (int) (sum % 1_000_000_007);
    }
}
