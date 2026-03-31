package removeAdjacentAlmostEqualCharacters;

public class RemoveAdjacentAlmostEqualCharacters {
    public int removeAlmostEqualCharacters(String word) {
        char[] chars = word.toCharArray();
        int ans = 0;
        for (int i = 1; i < chars.length; i += 2) {
            if (chars[i] == chars[i - 1] || Math.abs(chars[i] - chars[i - 1]) == 1) {
                ans++;
            } else {
                i--;
            }
        }
        return ans;
    }
}
