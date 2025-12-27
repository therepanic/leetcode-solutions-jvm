package reverseWordsWithSameVowelCount;

public class ReverseWordsWithSameVowelCount {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        int[] vowels = new int[s.length()];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                char ch = words[i].charAt(j);
                if (ch == 'a') {
                    vowels[i]++;
                } else if (ch == 'e') {
                    vowels[i]++;
                } else if (ch == 'i') {
                    vowels[i]++;
                } else if (ch == 'o') {
                    vowels[i]++;
                } else  if (ch == 'u') {
                    vowels[i]++;
                }
            }
            if (i >= 1) {
                if (vowels[0] == vowels[i]) {
                    words[i] = new StringBuilder(words[i]).reverse().toString();
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < words.length; i++) {
            if (i != words.length - 1) {
                ans.append(words[i]).append(" ");
            } else {
                ans.append(words[i]);
            }
        }
        return ans.toString();
    }
}
