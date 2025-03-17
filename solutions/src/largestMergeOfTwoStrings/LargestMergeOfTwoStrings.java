package largestMergeOfTwoStrings;

public class LargestMergeOfTwoStrings {
    public static String largestMerge(String word1, String word2) {
        StringBuilder word1Sb = new StringBuilder(word1);
        StringBuilder word2Sb = new StringBuilder(word2);
        StringBuilder merge = new StringBuilder();
        int n = word1.length() + word2.length();
        for (int i = 0; i < n; i++) {
            if (word2Sb.isEmpty() || !word1Sb.isEmpty() && word1Sb.charAt(0) > word2Sb.charAt(0)) {
                merge.append(word1Sb.charAt(0));
                word1Sb.deleteCharAt(0);
            } else if (word1Sb.isEmpty() || !word2Sb.isEmpty() && word2Sb.charAt(0) > word1Sb.charAt(0)) {
                merge.append(word2Sb.charAt(0));
                word2Sb.deleteCharAt(0);
            } else if (!word1Sb.isEmpty() && !word2Sb.isEmpty()){
                if (word1Sb.compareTo(word2Sb) > 0) {
                    merge.append(word1Sb.charAt(0));
                    word1Sb.deleteCharAt(0);
                } else {
                    merge.append(word2Sb.charAt(0));
                    word2Sb.deleteCharAt(0);
                }
            }
        }
        return merge.toString();
    }
}
