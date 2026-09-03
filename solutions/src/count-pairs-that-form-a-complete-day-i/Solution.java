class Solution {
    public int countCompleteDayPairs(int[] hours) {
        Map<Integer, Integer> count = new HashMap<>();
        int answer = 0;
        for (int h : hours) {
            int v = h % 24;
            int a = (24 - v) % 24;
            answer += count.getOrDefault(a, 0);
            count.put(v, count.getOrDefault(v, 0) + 1);
        }
        return answer;
    }
}
