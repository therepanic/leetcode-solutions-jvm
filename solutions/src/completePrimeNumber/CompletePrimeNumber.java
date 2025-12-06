package completePrimeNumber;

public class CompletePrimeNumber {
    public boolean completePrime(int num) {
        String numVal = String.valueOf(num);
        StringBuilder prefix = new StringBuilder();
        StringBuilder suffix = new StringBuilder();
        for (int i = 0; i < numVal.length(); i++) {
            prefix.append(numVal.charAt(i));
            if (!isPrime(Integer.parseInt(prefix.toString()))) {
                return false;
            }
        }
        for (int i = numVal.length() - 1; i >= 0; i--) {
            suffix.insert(0, numVal.charAt(i));
            if (!isPrime(Integer.parseInt(suffix.toString()))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
