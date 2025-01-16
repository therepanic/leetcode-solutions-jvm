package minimumNumberOfMovesToMakePalindrome;

public class MinimumNumberOfMovesToMakePalindrome {
    public static int minMovesToMakePalindrome(String s) {
        StringBuilder sb = new StringBuilder(s);

        int c = 0;
        int l = 0;
        int r = sb.length() - 1;
        while (l <= r) {
            if (sb.charAt(l) != sb.charAt(r)) {
                int lt = -1;
                int rt = -1;

                for (int i = l + 1; i <= r; i++) {
                    if (sb.charAt(i) == sb.charAt(r)) {
                        lt = i;
                        break;
                    }
                }
                for (int i = r - 1; i >= l; i--) {
                    if (sb.charAt(i) == sb.charAt(l)) {
                        rt = i;
                        break;
                    }
                }
                int differL = lt - l;
                int differR = r - rt;

                if (differL <= differR) {
                    char ch = sb.charAt(lt);
                    sb.deleteCharAt(lt);
                    sb.insert(l, ch);

                    c += differL;
                } else {
                    char ch = sb.charAt(rt);
                    sb.deleteCharAt(rt);
                    sb.insert(r, ch);

                    c += differR;
                }
            }
            l++;
            r--;
        }

        return c;
    }
}
