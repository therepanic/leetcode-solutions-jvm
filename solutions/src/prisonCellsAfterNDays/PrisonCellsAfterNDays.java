package prisonCellsAfterNDays;

public class PrisonCellsAfterNDays {
    public int[] prisonAfterNDays(int[] cells, int n) {
        int[][] counts = new int[14][8];
        int[] temp = cells;
        for (int i = 0; i < 14; i++) {
            temp = operate(temp.clone());
            counts[i] = temp.clone();
        }
        return counts[(n - 1) % 14];
    }

    public int[] operate(int[] cells) {
        int[] og = cells.clone();
        og[0] = 0;
        og[cells.length - 1] = 0;
        for (int i = 1; i < cells.length - 1; i++) {
            if (cells[i - 1] == 1 && cells[i + 1] == 1 || cells[i - 1] == 0 && cells[i + 1] == 0) {
                og[i] = 1;
            } else {
                og[i] = 0;
            }
        }
        return og;
    }
}
