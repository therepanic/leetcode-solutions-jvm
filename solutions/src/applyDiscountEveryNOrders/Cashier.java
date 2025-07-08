package applyDiscountEveryNOrders;

import java.util.HashMap;
import java.util.Map;

public class Cashier {

    private final int n;
    private final double discount;
    private final Map<Integer, Integer> prices;
    private int count;

    public Cashier(int n, int discount, int[] products, int[] prices) {
        this.n = n;
        this.discount = (100 - discount) * 0.01;
        this.prices = new HashMap<>();
        for (int i = 0; i < products.length; i++) {
            this.prices.put(products[i], prices[i]);
        }
        this.count = 1;
    }

    public double getBill(int[] product, int[] amount) {
        double bill = 0;
        for (int i = 0; i < product.length; i++) {
            int curProduct = product[i];
            int curAmount = amount[i];
            double curPrice = this.prices.get(curProduct) * curAmount;
            if (this.count % this.n == 0) {
                curPrice *= this.discount;
            }
            bill += curPrice;
        }
        this.count++;
        return bill;
    }

}
