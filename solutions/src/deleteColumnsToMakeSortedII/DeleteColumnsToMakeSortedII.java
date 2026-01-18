package deleteColumnsToMakeSortedII;

public class DeleteColumnsToMakeSortedII {
    public int minDeletionSize(String[] strs) {
        int c = 0;
        boolean[] sorted = new boolean[strs.length - 1];
        for (int i = 0; i < strs[0].length(); i++) {
            boolean bad = false;
            for (int j = 0; j < strs.length - 1; j++) {
                if (!sorted[j] && strs[j].charAt(i) > strs[j + 1].charAt(i)) {
                    bad = true;
                    break;
                }
            }
            if (bad) {
                c++;
                continue;
            }
            for (int j = 0; j < strs.length - 1; j++) {
                if (!sorted[j] && strs[j].charAt(i) < strs[j + 1].charAt(i)) {
                    sorted[j] = true;
                }
            }
        }
        return c;
    }
}
