package maximumManhattanDistanceAfterKChanges;

public class MaximumManhattanDistanceAfterKChanges {

    public int maxDistance(String s, int k) {
        int answer = 0;
        int u = 0, l = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'N') {
                u++;
            } else if (c == 'S') {
                u--;
            } else if (c == 'W') {
                l++;
            } else if (c == 'E') {
                l--;
            }
            int uAbs = Math.abs(u);
            int lAbs = Math.abs(l);
            answer = Math.max(answer, Math.min(uAbs + lAbs + k * 2, i + 1));
        }
        return answer;
    }

}
