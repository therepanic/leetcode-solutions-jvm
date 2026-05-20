package findThePrefixCommonArrayOfTwoArrays;

public class FindThePrefixCommonArrayOfTwoArrays {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        boolean[] a = new boolean[A.length + 1];
        boolean[] b = new boolean[B.length + 1];
        int c = 0;
        int[] ans = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            a[A[i]] = true;
            b[B[i]] = true;
            if (A[i] == B[i] && (a[B[i]] || b[A[i]]))  {
                c++;
            } else {
                if (a[B[i]]) {
                    c++;
                }
                if (b[A[i]]) {
                    c++;
                }
            }
            ans[i] += c;
        }
        return ans;
    }
}
