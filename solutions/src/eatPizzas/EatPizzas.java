package eatPizzas;

import java.util.Arrays;

public class EatPizzas {
    public long maxWeight(int[] pizzas) {
        Arrays.sort(pizzas);
        int days = pizzas.length / 4;
        int it = pizzas.length - 1;
        long weight = 0;
        for (int day = 1; day <= days; day += 2) {
            weight += pizzas[it];
            it--;
        }
        it--;
        for (int day = 2; day <= days; day += 2) {
            weight += pizzas[it];
            it -= 2;
        }
        return weight;
    }
}
