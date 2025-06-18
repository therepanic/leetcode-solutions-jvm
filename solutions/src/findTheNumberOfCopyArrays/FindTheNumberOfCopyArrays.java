package findTheNumberOfCopyArrays;

public class FindTheNumberOfCopyArrays {

    public int countArrays(int[] original, int[][] bounds) {
        int min = bounds[0][0];
        int max = bounds[0][1];
        int answer = max - min + 1;
        for (int i = 1; i < bounds.length; i++) {
            int diff = original[i] - original[i - 1];
            min = Math.max(min + diff, bounds[i][0]);
            max = Math.min(max + diff, bounds[i][1]);
            answer = Math.min(max - min + 1, answer);
        }
        return answer < 0 ? 0 : answer;
    }

}
