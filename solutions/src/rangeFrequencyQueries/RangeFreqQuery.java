package rangeFrequencyQueries;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RangeFreqQuery {

    private final Map<Integer, List<Integer>> appearMap;

    public RangeFreqQuery(int[] arr) {
        this.appearMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            this.appearMap.computeIfAbsent(arr[i], f -> new ArrayList<>())
                    .add(i);
        }
    }

    public int query(int left, int right, int value) {
        if (this.appearMap.get(value) == null) {
            return 0;
        }
        List<Integer> t = this.appearMap.get(value);
        int l = 0;
        int r = t.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (t.get(mid) >= left) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        int i1 = l;
        l = 0;
        r = t.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (t.get(mid) <= right) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l - i1;
    }
}
