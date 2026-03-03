package findKthBitInNthBinaryString;

public class FindKthBitInNthBinaryString {
    public char findKthBit(int n, int k) {
        StringBuilder ans = new StringBuilder("0");
        for (int i = 1; i < n; i++) {
            StringBuilder nb = new StringBuilder(ans);
            for (int j = 0; j < nb.length(); j++) {
                if (nb.charAt(j) == '1') {
                    nb.setCharAt(j, '0');
                } else {
                    nb.setCharAt(j, '1');
                }
            }
            String toAdd = "1" + nb.reverse();
            ans.append(toAdd);
            if (k <= ans.length()) {
                return ans.charAt(k - 1);
            }
        }
        return '0';
    }
}
