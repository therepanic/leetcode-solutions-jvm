package calculateScoreAfterPerformingInstructions;

public class CalculateScoreAfterPerformingInstructions {
    public long calculateScore(String[] instructions, int[] values) {
        boolean[] checked = new boolean[instructions.length];
        long value = 0;
        for (int i = 0; i < instructions.length && i >= 0; i++) {
            if (checked[i]) return value;
            checked[i] = true;
            if (instructions[i].equals("jump")) {
                i += values[i];
                i--;
            } else {
                value += values[i];
            }
        }
        return value;
    }
}
