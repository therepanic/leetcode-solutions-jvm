package assignCookies;

import java.util.Arrays;

public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int count = 0;

        int playerIndex = 0;
        int pointer = 0;

        while (pointer < s.length && playerIndex < g.length) {
            while (pointer < s.length && s[pointer] < g[playerIndex]) {
                pointer++;
            }

            if (pointer < s.length && s[pointer] >= g[playerIndex]) {
                count++;
                pointer++;
            }


            playerIndex++;
        }


        return count;
    }
}
