package complexNumberMultiplication;

public class ComplexNumberMultiplication {
    public String complexNumberMultiply(String num1, String num2) {
        String[] split1 = num1.split("\\+");
        String[] split2 = num2.split("\\+");
        long real1 = Integer.parseInt(split1[0]), real2 = Integer.parseInt(split2[0]);
        long imm1 = Integer.parseInt(split1[1].substring(0, split1[1].length() - 1)), imm2 = Integer.parseInt(split2[1].substring(0, split2[1].length() - 1));
        return ((real1 * real2) - (imm1 * imm2)) + "+" + ((real1 * imm2) + (real2 * imm1)) + "i";
    }
}
