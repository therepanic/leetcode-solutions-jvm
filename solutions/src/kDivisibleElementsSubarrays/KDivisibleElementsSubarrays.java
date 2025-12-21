package kDivisibleElementsSubarrays;

import java.util.HashSet;
import java.util.Set;

public class KDivisibleElementsSubarrays {
    public int countDistinct(int[] nums, int k, int p) {
        long P = 911382323L;
        long MOD = 1_000_000_007L;
        Set<Long> hashes = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            long hash = 0;
            int c = 0;
            for (int j = i; j < nums.length; j++) {
                hash = (hash * P + nums[j]) % MOD;
                if (nums[j] % p == 0) {
                    c++;
                }
                if (c <= k) {
                    int len = j - i + 1;
                    long key = (hash << 32) ^ (long) len;
                    hashes.add(key);
                } else {
                    break;
                }
            }
        }
        return hashes.size();
    }
}
