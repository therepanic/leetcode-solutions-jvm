package peakIndexInAMountainArray;

public class PeakIndexInAMountainArray {
    public int peakIndexInMountainArray(int[] arr) {
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = (r - l) / 2 + l;

            int left = Integer.MIN_VALUE;
            int right = Integer.MIN_VALUE;

            if (mid - 1 >= 0) {
                left = arr[mid - 1];
            }

            if (mid + 1 < arr.length) {
                right = arr[mid + 1];
            }

            if (arr[mid] > left && arr[mid] > right) {
                return mid;
            } else if (arr[mid] < left) {
                r = mid - 1;
            } else if (arr[mid] < right){
                l = mid + 1;
            } else {
                break;
            }
        }

        return -1;
    }
}
