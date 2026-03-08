package numberOfStepsToReduceANumberInBinaryRepresentationToOne;

public class NumberOfStepsToReduceANumberInBinaryRepresentationToOne {
    public void divideTwo(StringBuilder sb) {
        sb.deleteCharAt(sb.length() - 1);
    }

    public void plusOne(StringBuilder sb) {
        int it = sb.length() - 1;
        for (int i = it; i >= 0; i--) {
            if (sb.charAt(i) == '1') {
                sb.setCharAt(i, '0');
            } else {
                sb.setCharAt(i, '1');
                return;
            }
        }
        sb.insert(0, '1');
    }

    public boolean isOne(StringBuilder sb) {
        for (int i = 0; i < sb.length() - 1; i++) {
            if (sb.charAt(i) == '1') {
                return false;
            }
        }
        return  sb.charAt(sb.length() - 1) == '1';
    }


    public int numSteps(String s) {
        StringBuilder sb = new StringBuilder(s);
        int c = 0;
        while (!isOne(sb)) {
            if (sb.charAt(sb.length() - 1) == '1') {
                plusOne(sb);
            } else {
                divideTwo(sb);
            }
            c++;
        }
        return c;
    }
}
