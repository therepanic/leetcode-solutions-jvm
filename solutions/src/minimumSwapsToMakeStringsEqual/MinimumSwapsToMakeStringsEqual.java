package minimumSwapsToMakeStringsEqual;

public class MinimumSwapsToMakeStringsEqual {
    public int minimumSwap(String s1, String s2) {
        int xy = 0;
        int yx = 0;
        for (int i = 0; i < s1.length(); i++) {
            char f = s1.charAt(i);
            char s = s2.charAt(i);
            if (f != s) {
                if (f == 'x') {
                    xy++;
                } else {
                    yx++;
                }
            }
        }
        if ((xy + yx) % 2 == 1) {
            return -1;
        }
        int ans = (xy / 2) + (yx / 2);
        if (xy % 2 == 1 && yx % 2 == 1) {
            ans += 2;
        }
        return ans;
    }
}
