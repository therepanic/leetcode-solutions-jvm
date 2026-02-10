package minimumSuffixFlips;

public class MinimumSuffixFlips {
    public int minFlips(String target) {
        char[] chars = target.toCharArray();
        boolean ok = false;
        int c = 0;
        for (int i = 0; i < target.length(); i++) {
            if (chars[i] == '1' && !ok) {
                c++;
                ok = true;
            } else if (chars[i] == '0' && ok) {
                c++;
                ok = false;
            }
        }
        return c;
    }
}
