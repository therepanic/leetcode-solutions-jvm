package sumOfEvenNumbersAfterQueries;

public class SumOfEvenNumbersAfterQueries {
    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        int[] answer = new int[queries.length];
        int it = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (val % 2 == 0) sum += val;
        }
        for (int[] query : queries) {
            int val = nums[query[1]];
            int newVal = val + query[0];
            if (newVal % 2 != 0 && val % 2 == 0) {
                sum -= val;
            } else if (newVal % 2 == 0 && val % 2 != 0) {
                sum += newVal;
            } else if (newVal % 2 == 0){
                sum -= val;
                sum += newVal;
            }
            nums[query[1]] = newVal;
            answer[it] = sum;
            it++;
        }
        return answer;
    }
}
