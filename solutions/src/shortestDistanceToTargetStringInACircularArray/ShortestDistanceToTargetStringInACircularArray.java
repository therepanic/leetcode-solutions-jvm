package shortestDistanceToTargetStringInACircularArray;

public class ShortestDistanceToTargetStringInACircularArray {
    public int closestTarget(String[] words, String target, int startIndex) {
        int c = 0;
        int ans = Integer.MAX_VALUE;
        for (int i = startIndex; i >= -words.length; i--) {
            if (words[(i + words.length) % words.length].equals(target)) {
                ans = c;
                break;
            }
            c++;
        }
        if (ans == Integer.MAX_VALUE) return -1;
        c = 0;
        for (int i = startIndex; i < words.length * 2; i++) {
            if (words[i % words.length].equals(target)) {
                ans = Math.min(ans, c);
                break;
            }
            c++;
        }
        return ans;
    }
}
