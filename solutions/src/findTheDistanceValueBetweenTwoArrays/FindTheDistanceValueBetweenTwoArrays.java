package findTheDistanceValueBetweenTwoArrays;

public class FindTheDistanceValueBetweenTwoArrays {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int c = 0;
        for (int v1 : arr1) {
            boolean ok = true;
            for (int v2 : arr2) {
                if (Math.abs(v1 - v2) <= d) {
                    ok = false;
                    break;
                }
            }
            if (ok) {
                c++;
            }
        }
        return c;
    }
}
