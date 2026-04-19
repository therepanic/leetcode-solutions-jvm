package stringWithoutAAAOrBBB;

public class StringWithoutAAAOrBBB {
    public String strWithout3a3b(int a, int b) {
        StringBuilder sb = new StringBuilder(a + b);
        char A = 'a'; char B = 'b';
        int i = a;
        int j = b;
        if (b > a) {
            i = b;
            j = a;
            A = 'b';
            B = 'a';
        }
        while (i-- > 0) {
            sb.append(A);
            if (i > j) {
                sb.append(A);
                i--;
            }
            if (j > 0) {
                sb.append(B);
                j--;
            }
        }
        return sb.toString();
    }
}
