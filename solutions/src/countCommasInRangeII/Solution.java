class Solution {
    public long countCommas(long n) {
        long bigger = 999;
        long count = 0;
        while (n > bigger) {
            count += n - bigger;
            bigger *= 1000;
            bigger += 999;
        }
        return count;
    }
}
