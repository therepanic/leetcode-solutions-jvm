package findThreeConsecutiveIntegersThatSumToAGivenNumber;

public class FindThreeConsecutiveIntegersThatSumToAGivenNumber {
    public long[] sumOfThree(long num) {
        long n = num / 3;
        if (n * 3 == num) {
            return new long[] {n - 1, n, n + 1};
        }
        return new long[] {};
    }
}
