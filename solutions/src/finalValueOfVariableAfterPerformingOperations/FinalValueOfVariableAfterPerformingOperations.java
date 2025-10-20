package finalValueOfVariableAfterPerformingOperations;

public class FinalValueOfVariableAfterPerformingOperations {
    public int finalValueAfterOperations(String[] operations) {
        int c = 0;
        for (String op : operations) {
            if (op.startsWith("--") || op.endsWith("--")) {
                c++;
            }
        }
        return operations.length - 2 * c;
    }
}
