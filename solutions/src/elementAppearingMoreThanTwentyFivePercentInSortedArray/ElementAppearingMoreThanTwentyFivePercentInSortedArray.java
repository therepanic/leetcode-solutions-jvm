package elementAppearingMoreThanTwentyFivePercentInSortedArray;

public class ElementAppearingMoreThanTwentyFivePercentInSortedArray {
    public int findSpecialInteger(int[] arr) {
        int el = -1;
        int c = 0;
        int all = arr.length;
        for (int v : arr) {
            if (v != el) {
                el = v;
                c = 1;
            } else {
                c++;
            }
            if (c > 0 && (double) c / all > 0.25) {
                return v;
            }
        }
        return -1;
    }
}
