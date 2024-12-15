package hIndex;

import java.util.Arrays;

public class HIndex {
    public static int hIndex(int[] citations) {
        Arrays.sort(citations);

        int hIndex = 0;

        for (int i = citations.length - 1; i >= 0; i--) {
            if (hIndex + 1 <= citations[i]) {
                hIndex++;
            } else {
                break;
            }
        }

        return hIndex;
    }
}
