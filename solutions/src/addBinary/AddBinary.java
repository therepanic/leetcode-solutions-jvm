package addBinary;

import java.math.BigInteger;

public class AddBinary {
    public String addBinary(String a, String b) {
        BigInteger av = new BigInteger(a, 2);
        BigInteger bv = new BigInteger(b, 2);
        return av.add(bv).toString(2);
    }
}
