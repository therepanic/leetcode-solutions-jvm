package determineColorOfAChessboardSquare;

public class DetermineColorOfAChessboardSquare {
    public boolean squareIsWhite(String coordinates) {
        int a = (coordinates.charAt(0) - 'a') % 2;
        int b = (coordinates.charAt(1) - '0') % 2;
        if (a == 0) {
            return b == 0;
        } else {
            return b != 0;
        }
    }
}
