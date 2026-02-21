package rankTeamsByVotes;

import java.util.Arrays;

public class RankTeamsByVotes {
    public String rankTeams(String[] votes) {
        int[][] positions = new int[26][27];
        for (int i = 0; i < votes[0].length(); i++) {
            int ch = votes[0].charAt(i) - 'A';
            positions[ch][26] = ch;
        }
        for (int i = 0; i < votes.length; i++) {
            for (int j = 0; j < votes[i].length(); j++) {
                positions[votes[i].charAt(j) - 'A'][j]--;
            }
        }
        Arrays.sort(positions, (p1, p2) -> {
            for (int i = 0; i < 27; i++) {
                if (p1[i] != p2[i]) {
                    return Integer.compare(p1[i], p2[i]);
                }
            }
            return 0;
        });
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < votes[0].length(); i++) {
            ans.append((char) (positions[i][26] + 'A'));
        }
        return ans.toString();
    }
}
