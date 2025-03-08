package minimumRecolorsToGetKConsecutiveBlackBlocks;

public class MinimumRecolorsToGetKConsecutiveBlackBlocks {
    public int minimumRecolors(String blocks, int k) {
        char[] blockChars = blocks.toCharArray();
        int l = 0;
        int blackCount = 0;
        int minRecolors = Integer.MAX_VALUE;
        for (int r = 0; r < blockChars.length; r++) {
            if (blockChars[r] == 'B') {
                blackCount++;
            }
            if (r - l + 1 > k) {
                if (blockChars[l] == 'B') {
                    blackCount--;
                }
                l++;
            }
            if (r - l + 1 == k) {
                minRecolors = Math.min(minRecolors, r - l + 1 - blackCount);
            }
        }
        return minRecolors;
    }
}
