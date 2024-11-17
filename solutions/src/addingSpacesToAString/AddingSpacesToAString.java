package addingSpacesToAString;

public class AddingSpacesToAString {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder(s);
        int prefix = 0;
        for (int space : spaces) {
            sb.insert(space + prefix, " ");
            prefix++;
        }

        return sb.toString();
    }
}
