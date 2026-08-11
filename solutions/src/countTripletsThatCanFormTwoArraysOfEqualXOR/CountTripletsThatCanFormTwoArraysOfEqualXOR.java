package countTripletsThatCanFormTwoArraysOfEqualXOR;

public class CountTripletsThatCanFormTwoArraysOfEqualXOR {
    public int countTriplets(int[] arr) {
        int[] pref = new int[arr.length + 1];
        for (int i = 1; i <= arr.length; i++) {
            pref[i] = pref[i - 1] ^ arr[i - 1];
        }
        int c = 0;
        for (int i = 0; i <= arr.length; i++) {
            for (int j = i + 1; j <= arr.length; j++) {
                if (pref[i] == pref[j]) {
                    c += j - i - 1;
                }
            }
        }
        return c;
    }
}
