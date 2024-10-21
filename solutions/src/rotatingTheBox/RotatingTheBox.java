package rotatingTheBox;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class RotatingTheBox {
    public static char[][] rotateTheBox(char[][] box) {
        for (int i = 0; i < box.length; i++) {
            int emptyIndex = box[0].length - 1;

            for (int j = box[0].length - 1; j >= 0; j--) {

                if (box[i][j] == '#') {
                    if (emptyIndex != j) {
                        box[i][emptyIndex] = '#';
                        box[i][j] = '.';
                    }
                    emptyIndex--;
                } else if (box[i][j] == '*') {
                    emptyIndex = j - 1;
                }
            }
        }

        char[][] newBox = new char[box[0].length][box.length];

        for (int i = 0; i < box.length; i++) {
            for (int j = 0; j < box[0].length; j++) {
                newBox[j][box.length - i - 1] = box[i][j];
            }
        }

        return newBox;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(rotateTheBox(new char[][]{{'#', '#', '*', '.', '*', '.'},
                {'#', '#', '#', '*', '.', '.'},
                {'#', '#', '#', '.', '#', '.'}})));
    }
}
