package removeColoredPiecesIfBothNeighborsAreTheSameColor;

public class RemoveColoredPiecesIfBothNeighborsAreTheSameColor {
    public boolean winnerOfGame(String colors) {
        int ac = 0;
        int bc = 0;
        char[] sChars = colors.toCharArray();
        for (int i = 1; i < sChars.length - 1; i++) {
            if (sChars[i - 1] == 'A' && sChars[i] == 'A' && sChars[i + 1] == 'A') {
                ac++;
            } else if (sChars[i - 1] == 'B' && sChars[i] == 'B' && sChars[i + 1] == 'B') {
                bc++;
            }
        }
        return ac > bc;
    }
}
