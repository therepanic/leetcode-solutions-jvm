package maximumPopulationYear;

public class MaximumPopulationYear {
    public int maximumPopulation(int[][] logs) {
        int[] year = new int[2051];

        for (int[] log : logs) {
            year[log[0]]++;
            year[log[1]]--;
        }

        int maxSum = Integer.MIN_VALUE;
        int answer = 0;
        for (int i = 1950; i < year.length; i++) {
            year[i] += year[i - 1];

            if (year[i] > maxSum) {
                answer = i;
                maxSum = year[i];
            }
        }

        return answer;
    }
}
