package kthSmallestElementInASortedMatrix;

public class KthSmallestElementInASortedMatrix {
    public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0];
        int high = matrix[matrix.length - 1][matrix.length - 1];

        while(low < high) {
            int mid = low + (high - low) / 2;
            int count = lessEqual(matrix, mid);

            if(count < k){
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;

    }

    public int lessEqual(int[][] matrix, int target){
        int count = 0;
        int i = matrix.length - 1;
        int j = 0;

        while (i >= 0 && j < matrix.length){
            if (matrix[i][j] > target) {
                i--;
            } else {
                count += i + 1;
                j++;
            }
        }
        return count;
    }
}
