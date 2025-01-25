package makeLexicographicallySmallestArrayBySwappingElements;

import java.util.*;

public class MakeLexicographicallySmallestArrayBySwappingElements {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int[][] all = new int[nums.length][2];
        for (int i = 0; i < nums.length; i++) {
            all[i] = new int[] {nums[i], i};
        }
        Arrays.sort(all, Comparator.comparingInt(p -> p[0]));
        List<List<int[]>> pairs = new ArrayList<>(List.of(new ArrayList<>(List.of(all[0]))));
        for (int i = 1; i < all.length; i++) {
            if (Math.abs(pairs.getLast().getLast()[0] - all[i][0]) <= limit) {
                pairs.getLast().addLast(all[i]);
            } else {
                pairs.addLast(new ArrayList<>(List.of(all[i])));
            }
        };
        for (List<int[]> group : pairs) {
            List<Integer> values = new ArrayList<>();
            List<Integer> indices = new ArrayList<>();
            for (int[] pair : group) {
                values.add(pair[0]);
                indices.add(pair[1]);
            }
            Collections.sort(values);
            Collections.sort(indices);
            for (int i = 0; i < values.size(); i++) {
                nums[indices.get(i)] = values.get(i);
            }
        }
        return nums;
    }
}
