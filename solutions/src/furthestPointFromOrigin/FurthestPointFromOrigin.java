package furthestPointFromOrigin;

public class FurthestPointFromOrigin {
    public int furthestDistanceFromOrigin(String moves) {
        int first = 0;
        int second = 0;
        for (int i = 0; i < moves.length(); i++) {
            char ch = moves.charAt(i);
            if (ch == 'L' || ch == '_') {
                first--;
                if (ch == 'L') {
                    second--;
                }
            }
            if (ch == 'R' || ch == '_') {
                second++;
                if (ch == 'R') {
                    first++;
                }
            }
        }
        return Math.max(Math.abs(first), Math.abs(second));
    }
}
