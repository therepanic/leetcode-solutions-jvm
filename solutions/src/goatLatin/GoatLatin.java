package goatLatin;

public class GoatLatin {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder ans = new StringBuilder();
        int c = 1;
        for (int i = 0; i < words.length; i++) {
            char first = Character.toLowerCase(words[i].charAt(0));
            StringBuilder last = new StringBuilder(i == words.length - 1 ? "" : " ");
            if (first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u') {
                ans.append(words[i]).append("ma");
            } else {
                ans.append(words[i].substring(1)).append(words[i].charAt(0)).append("ma");
            }
            ans.append("a".repeat(c));
            ans.append(last);
            c++;
        }
        return ans.toString();
    }
}
