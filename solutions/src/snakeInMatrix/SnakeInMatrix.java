package snakeInMatrix;

import java.util.List;

public class SnakeInMatrix {
    public int finalPositionOfSnake(int n, List<String> commands) {
        int x = 0;
        int y = 0;
        for (String command : commands) {
            if (command.equals("LEFT")) {
                x--;
            } else if (command.equals("RIGHT")) {
                x++;
            } else if (command.equals("UP")) {
                y--;
            } else if (command.equals("DOWN")) {
                y++;
            }
        }
        return (y * n) + x;
    }
}
