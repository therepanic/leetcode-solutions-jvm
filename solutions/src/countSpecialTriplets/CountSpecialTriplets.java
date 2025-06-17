package countSpecialTriplets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountSpecialTriplets {

    public static int specialTriplets(int[] nums) {
        Map<Integer, List<Integer>> numValsMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            numValsMap.computeIfAbsent(nums[i], p -> new ArrayList<>()).add(i);
        }
        long c = 0;
        for (var entry : numValsMap.entrySet()) {
            int val = entry.getKey();
            List<Integer> values = entry.getValue();
            if (val == 0) {
                int n = values.size();
                if (n >= 3) {
                    c += (long) n * (n - 1) * (n - 2) / 6;
                }
                continue;
            }
            if (values.size() >= 2 && val % 2 == 0) {
                int search = val / 2;
                List<Integer> searchValues = numValsMap.get(search);
                if (searchValues == null) {
                    continue;
                }
                int i = 0;
                for (int it : searchValues) {
                    while (i < values.size() && values.get(i) < it) {
                        i++;
                    }
                    c += (long) i * (values.size() - i);
                }
            }
        }
        return (int) (c % (1e9 + 7));
    }

    public static int min(int l, int r, List<Integer> nums, int val) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums.get(mid) >= val) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static int max(int l, int r, List<Integer> nums, int val) {
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums.get(mid) <= val) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }

}
