package numberOfWonderfulSubstrings;

public class NumberOfWonderfulSubstrings {
    public long wonderfulSubstrings(String word) {
        long res = 0;
        int[] freq = new int[1024];
        freq[0] = 1;
        int mask = 0;
        for (int i = 0; i < word.length(); i++) {
            int bit = word.charAt(i) - 'a';
            mask ^= (1 << bit);
            res += freq[mask];
            freq[mask]++;
            for (int j = 0; j < 10; j++) {
                res += freq[mask ^ (1 << j)];
            }
        }
        return res;
    }
}
