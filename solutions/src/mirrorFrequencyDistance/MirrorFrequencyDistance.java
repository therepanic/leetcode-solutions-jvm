package mirrorFrequencyDistance;

public class MirrorFrequencyDistance {

    public int mirrorFrequency(String s) {
        int[] mapCount = new int[128];
        boolean[] visited = new boolean[128];
        char[] chars = s.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            char ch = chars[i];
            mapCount[ch]++;
        }
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = chars[i];
            char rch;
            if (Character.isDigit(ch)) {
                rch = (char) ('9' - ch + '0');
            } else {
                rch = (char) ('z' - (ch - 'a'));
            }
            if (visited[ch] || visited[rch]) continue;
            visited[ch] = true;
            visited[rch] = true;
            ans += Math.abs(mapCount[ch] - mapCount[rch]);
        }
        return ans;
    }
}
