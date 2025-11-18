package oneBitAnd2BitCharacters;

public class OneBitAnd2BitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int last = 0;
        while (last < n - 1) {
            last += bits[last] == 1 ? 2 : 1;
        }
        return last == n - 1;
    }
}
