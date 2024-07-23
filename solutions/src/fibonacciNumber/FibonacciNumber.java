package fibonacciNumber;

public class FibonacciNumber {
    public int fib(int n) {
        if (n < 2) {
            return n;
        }

        int prePre = 0;
        int pre = 1;

        int answer = 1;

        for (int i = 2; i <= n; i++) {
            answer = pre + prePre;

            prePre = pre;
            pre = answer;
        }

        return answer;
    }
}
