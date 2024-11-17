package addingSpacesToAString;

public class AddingSpacesToAString {
    public String addSpaces(String s, int[] spaces) {
        char[] sChars = s.toCharArray();
        char[] chars = new char[s.length() + spaces.length];

        int spaceIndex = 0;

        int prefix = 0;

        int i = 0;

        while (i < sChars.length) {
            if (sChars[i] + prefix == spaces[spaceIndex]) {
                chars[i] = ' ';
                spaceIndex++;
                prefix++;
                continue;
            }

            chars[i] = sChars[i];
            prefix++;
            i++;
        }

        return String.valueOf(chars);
    }
}
