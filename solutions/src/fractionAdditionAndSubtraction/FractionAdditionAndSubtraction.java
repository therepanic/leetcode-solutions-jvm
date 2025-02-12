package fractionAdditionAndSubtraction;

public class FractionAdditionAndSubtraction {
    public static String fractionAddition(String expression) {
        char[] expressionChars = expression.toCharArray();
        int numerator = 0;
        int deNumerator = 0;
        boolean slash = false;
        boolean plus = true;
        int sumNumerator = 0;
        int sumDeNumerator = 1;
        for (char c : expressionChars) {
            if (Character.isDigit(c) && !slash) {
                numerator *= 10;
                numerator += Character.getNumericValue(c);
            } else if (Character.isDigit(c) && slash) {
                deNumerator *= 10;
                deNumerator += Character.getNumericValue(c);
            } else if (c == '/') {
                slash = true;
            } else if (c == '-') {
                int[] answer = calculate(sumNumerator, sumDeNumerator, numerator, deNumerator, plus);
                sumNumerator = answer[0];
                sumDeNumerator = answer[1];
                numerator = 0;
                deNumerator = 0;
                slash = false;
                plus = false;
            } else if (c == '+') {
                int[] answer = calculate(sumNumerator, sumDeNumerator, numerator, deNumerator, plus);
                sumNumerator = answer[0];
                sumDeNumerator = answer[1];
                numerator = 0;
                deNumerator = 0;
                slash = false;
                plus = true;
            }
        }
        int[] answer = calculate(sumNumerator, sumDeNumerator, numerator, deNumerator, plus);
        if (answer[0] != 0) {
            int common = mostCommonMultiple(Math.abs(answer[0]), Math.abs(answer[1]));
            answer[0] /= common;
            answer[1] /= common;
        }
        return answer[0] + "/" + answer[1];
    }

    private static int mostCommonMultiple(int x, int y) {
        if (x<=0 || y<=0) throw new UnsupportedOperationException("Incorrect input");
        while(x!=0 && y!=0){
            if (x>y) x=x%y;
            else y=y%x;
        }
        return x+y;
    }

    public static int[] calculate(int numerator1, int deNumerator1, int numerator2, int deNumerator2, boolean plus) {
        if (numerator2 == 0 && deNumerator2 == 0) return new int[] {0, 1};
        if (deNumerator1 != deNumerator2) {
            numerator2 *= deNumerator1;
            numerator1 *= deNumerator2;
            deNumerator1 *= deNumerator2;
        }
        if (plus) {
            numerator1 += numerator2;
        } else {
            numerator1 -= numerator2;
        }
        if (numerator1 == 0) {
            return new int[] {0, 1};
        }
        return new int[] {numerator1, deNumerator1};
    }
}

