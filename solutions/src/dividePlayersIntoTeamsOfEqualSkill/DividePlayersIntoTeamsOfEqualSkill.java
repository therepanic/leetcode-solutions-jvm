package dividePlayersIntoTeamsOfEqualSkill;

import java.util.Arrays;

public class DividePlayersIntoTeamsOfEqualSkill {
    public long dividePlayers(int[] skill) {
        Arrays.sort(skill);

        int l = 0;
        int r = skill.length - 1;

        int needSkill = skill[0] + skill[skill.length - 1];
        long chemistry = 0;

        while (l < r) {
            if (skill[l] + skill[r] != needSkill) {
                return -1;
            }
            chemistry += skill[l] * skill[r];
            l++;
            r--;
        }

        return chemistry;
    }
}
