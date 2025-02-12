package clumsyFactorial;

import java.util.Stack;

public class ClumsyFactorial {
    public static int clumsy(int n) {
        int step = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(n);
        for (int i = n - 1; i >= 1; i--) {
            switch (step) {
                case 0 -> {
                    stack.add(stack.pop() * i);
                    step = 1;
                }
                case 1 -> {
                    stack.add(stack.pop() / i);
                    step = 2;
                }
                case 2 -> {
                    stack.add(i);
                    step = 3;
                }
                case 3 -> {
                    stack.add(-i);
                    step = 0;
                }
            }
        }
        int ans = 0;
        while (!stack.isEmpty()) {
            ans += stack.pop();
        }
        return ans;
    }
}
