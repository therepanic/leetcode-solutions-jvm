class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, List<Integer>> values = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
             values.computeIfAbsent(nums[i], _ -> new ArrayList<>()).add(i);
        }
        int c = 0;
        for (var entry : values.entrySet()) {
            if (entry.getValue().size() == 3
                && entry.getValue().get(1) - entry.getValue().get(0) == entry.getValue().get(2) - entry.getValue().get(1)) {
                  c++;
            }
        }
        return c;
    }
}
