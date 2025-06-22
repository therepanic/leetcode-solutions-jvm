package divideAStringIntoGroupsOfSizeK;

public class DivideAStringIntoGroupsOfSizeK {

    public String[] divideString(String s, int k, char fill) {
        int size = s.length() / k;
        if (s.length() % k != 0) {
            size++;
        }
        String[] ans = new String[size];
        StringBuilder sb = new StringBuilder();
        int it = 0;
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            if ((i + 1) % k == 0) {
                ans[it] = sb.toString();
                sb.setLength(0);
                it++;
            }
        }
        if (!sb.isEmpty()) {
            while (sb.length() != k) {
                sb.append(fill);
            }
            ans[it] = sb.toString();
        }
        return ans;
    }

}
