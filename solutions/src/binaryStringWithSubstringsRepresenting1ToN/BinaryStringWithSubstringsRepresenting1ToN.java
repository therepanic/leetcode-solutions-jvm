package binaryStringWithSubstringsRepresenting1ToN;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

public class BinaryStringWithSubstringsRepresenting1ToN {

    public boolean queryString(String s, int n) {
        Set<BigInteger> seen = new HashSet<>();
        BigInteger limit = BigInteger.valueOf(n);
        BigInteger one = BigInteger.ONE;
        for (int i = 0; i < s.length(); i++) {
            BigInteger val = BigInteger.ZERO;
            for (int j = i; j < s.length(); j++) {
                val = val.shiftLeft(1).add(BigInteger.valueOf(s.charAt(j) - '0'));
                if (val.compareTo(limit) > 0) break;
                if (val.compareTo(one) >= 0 && seen.add(val) && seen.size() == n) {
                    return true;
                }
            }
        }
        return seen.size() == n;
    }
}
