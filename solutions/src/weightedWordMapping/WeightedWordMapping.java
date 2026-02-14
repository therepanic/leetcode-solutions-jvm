package weightedWordMapping;

public class WeightedWordMapping {
    public String mapWordWeights(String[] words, int[] weights) {
        StringBuilder ans = new StringBuilder();
        for (String word : words) {
            int sum = 0;
            for (int i = 0; i < word.length(); i++) {
                sum += weights[word.charAt(i) - 'a'];
            }
            ans.append((char) ((25 - (sum % 26)) + 'a'));
        }
        return ans.toString();
    }
}
