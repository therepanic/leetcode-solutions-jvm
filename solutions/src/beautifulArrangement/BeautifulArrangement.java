package beautifulArrangement;

public class BeautifulArrangement {
    public static int countArrangement(int n) {
        boolean[] checked = new boolean[n + 1];
        int[] answer = new int[1];
        bypass(n, 1, checked, answer);
        return answer[0];
    }

    private static void bypass(int n, int it, boolean[] checked, int[] answer) {
        if (it > n) {
            answer[0]++;
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!checked[i] && (i % it == 0 || it % i == 0)) {
                checked[i] = true;
                bypass(n, it + 1, checked, answer);
                checked[i] = false;
            }
        }
    }
}
