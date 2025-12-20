package deleteColumnsToMakeSorted;

public class DeleteColumnsToMakeSorted {
    public int minDeletionSize(String[] strs) {
        int c = 0;
        first: for (int i = 0; i < strs[0].length(); i++) {
            int last = strs[0].charAt(i) - 'a';
            for (int j = 1; j < strs.length; j++) {
                int cur = strs[j].charAt(i) - 'a';
                if (last > cur) {
                    c++;
                    continue first;
                } else {
                    last = cur;
                }
            }
        }
        return c;
    }
}
