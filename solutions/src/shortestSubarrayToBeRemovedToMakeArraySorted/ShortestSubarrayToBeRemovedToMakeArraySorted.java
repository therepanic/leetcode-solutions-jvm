package shortestSubarrayToBeRemovedToMakeArraySorted;

public class ShortestSubarrayToBeRemovedToMakeArraySorted {
    public static int findLengthOfShortestSubarray(int[] arr) {
        int start = 1;
        while (start < arr.length) {
            if (arr[start] < arr[start - 1]) {
                break;
            }
            start++;
        }
        if (start == arr.length) return 0;
        int end = arr.length - 2;
        while (end >= 0) {
            if (arr[end] > arr[end + 1]) {
                break;
            }
            end--;
        }
        int result = Math.min(arr.length - start, end + 1);
        int i = 0, j = end + 1;
        while (i < start && j < arr.length) {
            if (arr[i] <= arr[j]) {
                result = Math.min(result, j - i - 1);
                i++;
            } else {
                j++;
            }
        }
        return result;
    }
}
