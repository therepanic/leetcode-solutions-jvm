package maximumSwap;

public class MaximumSwap {

    public int maximumSwap(int num) {
        char[] numChars = String.valueOf(num).toCharArray();
        int n = numChars.length;
        int[] maxArr = new int[n];
        int maxVal = numChars[n - 1] - '0';
        int[] indexMaxVal = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            if (numChars[i] - '0' > maxVal) {
                indexMaxVal[i] = i;
                maxVal = numChars[i] - '0';
            } else {
                indexMaxVal[i] = i == n - 1 ? i : indexMaxVal[i + 1];
            }
            maxArr[i] = maxVal;
        }
        for (int i = 0; i < n - 1; i++) {
            if (numChars[i] - '0' < maxArr[i]) {
                char maxArrVal = (char) (maxArr[i] + '0');
                numChars[indexMaxVal[i]] = numChars[i];
                numChars[i] = maxArrVal;
                return Integer.parseInt(String.valueOf(numChars));
            }
        }
        return Integer.parseInt(String.valueOf(numChars));
    }

}
