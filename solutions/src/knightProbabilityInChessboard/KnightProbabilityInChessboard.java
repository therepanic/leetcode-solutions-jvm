package knightProbabilityInChessboard;

import java.util.Arrays;

public class KnightProbabilityInChessboard {
    public double knightProbability(int n, int k, int row, int column) {
        double[][][] helper = new double[n][n][k + 1];

        return helper(n, k, row, column, helper);
    }

    public double helper(int n, int k, int row, int column, double[][][] helper) {
        if (k < 0) {
            return 1;
        }

        if (row < 0 || column < 0 || row >= n || column >= n) {
            return 0;
        }

        if (helper[row][column][k] == 0) {
            double one = helper(n, k - 1, row - 2, column + 1, helper) / 8;
            double two = helper(n, k - 1, row - 2, column - 1, helper) / 8;
            double three = helper(n, k - 1, row - 1, column + 2, helper) / 8;
            double four = helper(n, k - 1, row - 1, column - 2, helper) / 8;

            double five = helper(n, k - 1, row + 1, column + 2, helper) / 8;
            double six = helper(n, k - 1, row + 1, column - 2, helper) / 8;
            double seven = helper(n, k - 1, row + 2, column - 1, helper) / 8;
            double eight = helper(n, k - 1, row + 2, column + 1, helper) / 8;

            helper[row][column][k] = one + two + three + four + five + six + seven + eight;
        }


        return helper[row][column][k];
    }


}
