package maximumSwap;

public class MaximumSwap {
    public int maximumSwap(int num) {
        StringBuilder numSb = new StringBuilder(String.valueOf(num));

        int max = num;

        for (int i = 0; i < numSb.length(); i++) {
            for (int j = i + 1; j < numSb.length(); j++) {
                char c = numSb.charAt(i);

                numSb.setCharAt(i, numSb.charAt(j));
                numSb.setCharAt(j, c);

                max = Math.max(max, Integer.parseInt(numSb.toString()));

                c = numSb.charAt(i);

                numSb.setCharAt(i, numSb.charAt(j));
                numSb.setCharAt(j, c);
            }
        }

        return max;
    }
}
