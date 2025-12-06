package maximumSubstringsWithDistinctStart;

public class MaximumSubstringsWithDistinctStart {

    public int maxDistinct(String s) {
        boolean[] arr = new boolean[26];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int it = s.charAt(i) - 'a';
            if (!arr[it]) {
                count++;
                arr[it] = true;
            }
        }
        return count;
    }

}
