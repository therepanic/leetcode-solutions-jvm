package maximumManhattanDistanceAfterAllMoves;

public class MaximumManhattanDistanceAfterAllMoves {
    public int maxDistance(String moves) {
        int x = 0;
        int y = 0;
        int free = 0;
        for (int i = 0; i < moves.length(); i++) {
            char ch = moves.charAt(i);
            switch (ch) {
                case 'U' -> y++;
                case 'D' -> y--;
                case 'R' -> x++;
                case 'L' -> x--;
                case '_' -> free++;
            }
        }
        return Math.abs(x) + Math.abs(y) + free;
    }
}
