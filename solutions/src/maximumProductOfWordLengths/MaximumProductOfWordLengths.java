package maximumProductOfWordLengths;

import java.util.Set;

public class MaximumProductOfWordLengths {
    public static int maxProduct(String[] words) {
        boolean[] charsCount = new boolean[26];
        int maxProduct = 0;

        for (int i = 0; i < words.length; i++) {
            char[] a = words[i].toCharArray();

            for (char c : a) {
                charsCount[c - 'a'] = true;
            }


            for (int j = i + 1; j < words.length; j++) {
                char[] b = words[j].toCharArray();
                boolean isOk = true;

                for (char c : b) {
                    if (charsCount[c - 'a']) {
                        isOk = false;
                        break;
                    }
                }

                if (isOk) {
                    maxProduct = Math.max(maxProduct, a.length * b.length);
                }
            }

            for (char c : a) {
                charsCount[c - 'a'] = false;
            }
        }

        return maxProduct;
    }
}
