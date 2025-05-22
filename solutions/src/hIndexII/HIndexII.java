package hIndexII;

public class HIndexII {
    public int hIndex(int[] citations) {
        int l = 0;
        int r = citations.length - 1;
        int hIndex = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (citations[mid] > citations.length - mid - 1) {
                hIndex = citations.length - mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return hIndex;
    }
}
