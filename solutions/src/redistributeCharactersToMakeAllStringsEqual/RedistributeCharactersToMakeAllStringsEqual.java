package redistributeCharactersToMakeAllStringsEqual;

public class RedistributeCharactersToMakeAllStringsEqual {
    public boolean makeEqual(String[] words) {
        int[] count = new int[26];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                count[words[i].charAt(j) - 'a']++;
            }
        }
        for (int c : count) {
            if (c != 0 && c % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}
