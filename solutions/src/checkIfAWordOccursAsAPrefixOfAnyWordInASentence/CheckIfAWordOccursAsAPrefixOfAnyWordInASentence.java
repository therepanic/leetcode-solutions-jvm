package checkIfAWordOccursAsAPrefixOfAnyWordInASentence;

public class CheckIfAWordOccursAsAPrefixOfAnyWordInASentence {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] sentences = sentence.split(" ");

        for (int i = 0; i < sentences.length; i++) {
            if (sentences[i].equals(searchWord) || sentences[i].startsWith(searchWord)) {
                return i + 1;
            }
        }

        return - 1;
    }
}
