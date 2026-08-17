package maximumGapBetweenStations;

public class MaximumGapBetweenStations {
    public int maximumGap(String skill, String station) {
        int[] earliest = new int[skill.length()];
        int[] latest = new int[skill.length()];
        char[] skills = skill.toCharArray();
        char[] stations = station.toCharArray();
        int it = 0;
        for (int i = 0; it < skills.length && i < stations.length; i++) {
            if (stations[i] == skills[it]) {
                earliest[it] = i;
                it++;
            }
        }
        it = skills.length - 1;
        for (int i = stations.length - 1; i >= 0 && it >= 0; i--) {
            if (stations[i] == skills[it]) {
                latest[it] = i;
                it--;
            }
        }
        int ans = 0;
        for (int i = 0; i < skill.length() - 1; i++) {
            ans = Math.max(ans, latest[i + 1] - earliest[i]);
        }
        return ans;
    }
}
