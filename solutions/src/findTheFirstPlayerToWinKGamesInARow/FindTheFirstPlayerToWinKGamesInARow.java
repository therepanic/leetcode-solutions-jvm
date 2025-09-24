package findTheFirstPlayerToWinKGamesInARow;

public class FindTheFirstPlayerToWinKGamesInARow {
    public int findWinningPlayer(int[] skills, int k) {
        int max = -1;
        int it = -1;
        int c = 0;
        for (int i = 0; i < skills.length; i++) {
            int skill = skills[i];
            if (skill > max) {
                max = skill;
                it = i;
                c = 0;
                if (i > 0 && skills[i] > skills[i - 1]) {
                    c++;
                }
            } else {
                c++;
            }
            if (c == k) {
                return it;
            }
        }
        return it;
    }
}
