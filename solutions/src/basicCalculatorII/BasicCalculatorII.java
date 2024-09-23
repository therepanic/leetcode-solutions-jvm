package basicCalculatorII;

import java.util.*;

public class BasicCalculatorII {
    public int calculate(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        char operation = '+';
        int currentNumber = 0;

        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);

            if (Character.isDigit(currentChar)) {
                currentNumber = currentNumber * 10 + Character.getNumericValue(currentChar);
            }

            if (!Character.isDigit(currentChar) && currentChar != ' ' || i == s.length() - 1) {
                if (operation == '+') {
                    stack.push(currentNumber);
                } else if (operation == '-') {
                    stack.push(-currentNumber);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currentNumber);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currentNumber);
                }

                operation = currentChar;
                currentNumber = 0;
            }
        }

        int answer = 0;

        for (int num : stack) {
            answer += num;
        }

        return answer;
    }
}
