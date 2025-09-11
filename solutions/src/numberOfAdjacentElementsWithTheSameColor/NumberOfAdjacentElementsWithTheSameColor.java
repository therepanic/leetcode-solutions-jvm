package numberOfAdjacentElementsWithTheSameColor;

public class NumberOfAdjacentElementsWithTheSameColor {
    public int[] colorTheArray(int n, int[][] queries) {
        int[] colors = new int[n];
        int[] answer = new int[queries.length];
        int pairs = 0;
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];
            if (query[0] - 1 >= 0 && colors[query[0] - 1] == colors[query[0]] && colors[query[0] - 1] != 0) {
                pairs--;
            }
            if (query[0] + 1 < colors.length && colors[query[0] + 1] == colors[query[0]] && colors[query[0] + 1] != 0) {
                pairs--;
            }
            colors[query[0]] = query[1];
            if (query[0] - 1 >= 0 && colors[query[0] - 1] == colors[query[0]] && colors[query[0] - 1] != 0) {
                pairs++;
            }
            if (query[0] + 1 < colors.length && colors[query[0] + 1] == colors[query[0]] && colors[query[0] + 1] != 0) {
                pairs++;
            }
            answer[i] = pairs;
        }
        return answer;
    }
}
