package numberOfUniqueXORTripletsII;

public class NumberOfUniqueXORTripletsII {
    public static int uniqueXorTriplets(int[] nums) {
        boolean[] resultSet = new boolean[4100];
        int[] histogram = new int[4100];
        for (int value : nums) {
            histogram[value]++;
            resultSet[value] = true;
        }
        boolean[] twoElementXors = new boolean[4100];
        for (int a = 0; a < 4100; a++) {
            if (histogram[a] == 0) continue;
            for (int b = a; b < 4100; b++) {
                if (histogram[b] == 0) continue;
                if (a == b && histogram[a] >= 2) {
                    twoElementXors[a ^ b] = true;
                } else if (a != b) {
                    twoElementXors[a ^ b] = true;
                }
            }
        }
        for (int mid = 0; mid < 4100; mid++) {
            if (!twoElementXors[mid]) continue;
            for (int c = 0; c < 4100; c++) {
                if (histogram[c] > 0) {
                    resultSet[mid ^ c] = true;
                }
            }
        }
        int distinctCount = 0;
        for (boolean exists : resultSet) {
            if (exists) distinctCount++;
        }
        return distinctCount;
    }
}
