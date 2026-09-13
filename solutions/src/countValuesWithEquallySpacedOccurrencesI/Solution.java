class Solution {
    public int countSpecialIntegers(int[] nums) {
        Map<Integer, List<Integer>> values = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
             values.computeIfAbsent(nums[i], _ -> new ArrayList<>()).add(i);
        }
        int c = 0;
        for (var entry : values.entrySet()) {
            if (entry.getValue().size() >= 3) {
                  int a = entry.getValue().get(1) - entry.getValue().get(0);
                  boolean ok = true;
                  for (int i = 2; i < entry.getValue().size(); i++) {
                      if (entry.getValue().get(i) - entry.getValue().get(i - 1) != a) {
                          ok = false;
                          break;
                      }
                  }
                  if (ok) {
                      c++;
                  }
            }
        }
        return c;
    }
}
