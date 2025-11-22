package minimumNumberOfFlipsToReverseBinaryString;

public class MinimumNumberOfFlipsToReverseBinaryString {
    public int minimumFlips(int n) {
        String bin = Integer.toBinaryString(n);
        String rev = new StringBuilder(bin).reverse().toString();
        int c = 0;
        for (int i = 0; i < bin.length(); i++) {
            if (bin.charAt(i) != rev.charAt(i)) {
                c++;
            }
        }
        return c;
    }
}
