package minimumNumberOfOperationsToMoveAllBallsToEachBox;

public class MinimumNumberOfOperationsToMoveAllBallsToEachBox {
    public static int[] minOperations(String boxes) {
        char[] boxesChars = boxes.toCharArray();

        int[] leftOperations = new int[boxes.length()];
        int[] rightOperations = new int[boxes.length()];

        boolean active = false;
        int oneCount = 0;
        for (int i = 0; i < boxesChars.length; i++) {
            if (active) {
                leftOperations[i] += leftOperations[i - 1] + oneCount;
            }

            if (boxesChars[i] == '1') {
                oneCount++;
                active = true;
            }
        }
        active = false;
        oneCount = 0;

        for (int i = rightOperations.length - 1; i >= 0; i--) {
            if (active) {
                rightOperations[i] += rightOperations[i + 1] + oneCount;
            }

            if (boxesChars[i] == '1') {
                oneCount++;
                active = true;
            }
        }

        int[] answer = new int[boxes.length()];

        for (int i = 0; i < rightOperations.length; i++) {
            answer[i] += rightOperations[i] + leftOperations[i];
        }

        return answer;
    }
}
