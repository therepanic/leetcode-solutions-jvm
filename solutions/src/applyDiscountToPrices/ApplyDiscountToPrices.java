package applyDiscountToPrices;

public class ApplyDiscountToPrices {
    public String discountPrices(String sentence, int discount) {
        StringBuilder sb = new StringBuilder();
        StringBuilder val = new StringBuilder();
        boolean add = false;
        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (ch == '$') {
                add = i == 0 || sentence.charAt(i - 1) == ' ';
                if (!val.isEmpty()) {
                    sb.append(val);
                    val.setLength(0);
                }
                sb.append(ch);
            } else if (add && ch == ' ') {
                add = false;
                if (!val.isEmpty()) {
                    double value = Double.parseDouble(val.toString());
                    double valueWithDiscount = value - value * discount / 100;
                    sb.append(String.format("%.2f", valueWithDiscount));
                    val.setLength(0);
                }
                sb.append(ch);
            } else if(!add && !Character.isDigit(ch)) {
                sb.append(ch);
            } else if (add && Character.isDigit(ch)) {
                val.append(ch);
            } else if (!add && Character.isDigit(ch)) {
                sb.append(ch);
            } else if (add && !Character.isDigit(ch)) {
                add = false;
                if (!val.isEmpty()) {
                    sb.append(val);
                    val.setLength(0);
                }
                sb.append(ch);
            }
        }
        if (!val.isEmpty()) {
            double value = Double.parseDouble(val.toString());
            double valueWithDiscount = value - value * discount / 100;
            sb.append(String.format("%.2f", valueWithDiscount));
            val.setLength(0);
        }
        return sb.toString();
    }
}
