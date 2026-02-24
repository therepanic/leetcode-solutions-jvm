package countSubstringsThatDifferByOneCharacter;

public class CountSubstringsThatDifferByOneCharacter {
    public int countSubstrings(String s, String t) {
       char[] sChars = s.toCharArray();
       char[] tChars = t.toCharArray();
       int c = 0;
       for (int i = 0; i < sChars.length; i++ ){
           for (int j = 0; j < tChars.length; j++) {
               if (sChars[i] != tChars[j]) {
                   int l = 1, r = 1;
                   while (Math.min(i - l, j - l) >= 0 && sChars[i - l] == tChars[j - l]) {
                       l++;
                   }
                   while (i + r < sChars.length && j + r < tChars.length && sChars[i + r] == tChars[j + r]) {
                       r++;
                   }
                   c += l * r;
               }
           }
       }
       return c;
    }

}
