package couponCodeValidator;

import java.util.ArrayList;
import java.util.List;

public class CouponCodeValidator {
    public List<String> validateCoupons(String[] code, String[] businessLine, boolean[] isActive) {
        int n = code.length;
        List<Integer> pairs = new ArrayList<>();
        f: for (int i = 0; i < n; i++) {
            String c = code[i];
            if (c.isEmpty()) {
                continue;
            }
            for (int j = 0; j < c.length(); j++) {
                char ch = c.charAt(j);
                if (ch != '_' && !Character.isAlphabetic(ch) && !Character.isDigit(ch)) {
                    continue f;
                }
            }
            String b = businessLine[i];
            if (!b.equals("electronics") && !b.equals("grocery") && !b.equals("pharmacy") && !b.equals("restaurant")) {
                continue;
            }
            if (!isActive[i]) {
                continue;
            }
            pairs.add(i);
        }
        pairs.sort((p1, p2) -> {
            if (businessLine[p1].equals(businessLine[p2])) {
                return code[p1].compareTo(code[p2]);
            } else {
                return businessLine[p1].compareTo(businessLine[p2]);
            }
        });
        return pairs.stream().map(p -> code[p])
                .toList();
    }
}
