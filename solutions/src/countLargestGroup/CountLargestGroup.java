package countLargestGroup;

import java.util.*;

public class CountLargestGroup {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> groups = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            int num = i;
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            groups.put(sum, groups.getOrDefault(sum, 0) + 1);
        }
        int maxSize = 0;
        for (int size : groups.values()) {
            maxSize = Math.max(maxSize, size);
        }
        int count = 0;
        for (int size : groups.values()) {
            if (size == maxSize) {
                count++;
            }
        }
        return count;
    }
}
