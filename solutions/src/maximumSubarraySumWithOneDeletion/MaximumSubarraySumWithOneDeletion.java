package maximumSubarraySumWithOneDeletion;

public class MaximumSubarraySumWithOneDeletion {

    public static void main(String[] args) {
    }

    public static int maximumSum(int[] arr) {
        int keep = arr[0];
        int delete = arr[0];
        int answer = arr[0];
        for (int i = 1; i < arr.length; i++) {
            delete = Math.max(keep, delete + arr[i]);
            keep = Math.max(arr[i], keep + arr[i]);
            answer = Math.max(answer, Math.max(keep, delete));
        }
        return answer;
    }
}
