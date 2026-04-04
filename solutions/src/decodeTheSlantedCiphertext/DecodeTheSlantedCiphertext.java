package decodeTheSlantedCiphertext;

public class DecodeTheSlantedCiphertext {
    public String decodeCiphertext(String encodedText, int rows) {
        int cols = encodedText.length() / rows;
        int i = 0;
        int j = 0;
        char[][] chars = new char[rows][cols];
        for (int it = 0; it < encodedText.length(); it++) {
            char ch = encodedText.charAt(it);
            if (j >= cols) {
                i++;
                j = 0;
            }
            chars[i][j] = ch;
            j++;
        }
        StringBuilder ans = new StringBuilder();
        for (int it = 0; it < cols; it++) {
            int x = 0;
            int y = it;
            while (x < rows && y < cols) {
                ans.append(chars[x][y]);
                x++;
                y++;
            }
        }
        return ans.toString().stripTrailing();
    }
}
