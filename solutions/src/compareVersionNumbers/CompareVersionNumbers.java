package compareVersionNumbers;

public class CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        String[] lit1 = version1.split("\\.");
        String[] lit2 = version2.split("\\.");
        int n = Math.max(lit1.length, lit2.length);
        for (int i = 0; i < n; i++) {
            int first = i < lit1.length ? Integer.parseInt(lit1[i]) : 0;
            int second = i < lit2.length ? Integer.parseInt(lit2[i]) : 0;
            if (first > second) {
                return 1;
            } else if (first < second) {
                return -1;
            }
        }
        return 0;
    }
}
