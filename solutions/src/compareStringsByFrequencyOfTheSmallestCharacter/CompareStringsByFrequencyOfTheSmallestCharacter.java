package compareStringsByFrequencyOfTheSmallestCharacter;

import java.util.Arrays;

public class CompareStringsByFrequencyOfTheSmallestCharacter {
    public static int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] wordCount = new int[words.length];

        for (int i = 0; i < wordCount.length; i++) {
            wordCount[i] = foo(words[i]);
        }
        Arrays.sort(wordCount);

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int c = foo(queries[i]);

            int l = 0;
            int r = wordCount.length - 1;

            while (l <= r) {
                int mid = (r + l) / 2;

                if (wordCount[mid] > c) {
                    answer[i] = wordCount.length - mid;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }

        return answer;
    }

    public static int foo(String str) {
        char ch = '-';
        int count = 0;

        for (char c : str.toCharArray()) {
            if (c == ch) {
                count++;
            } else if (ch == '-' || c < ch) {
                ch = c;
                count = 1;
            }
        }

        return count;
    }
}

