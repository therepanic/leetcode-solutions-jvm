package dailyTemperatures;

import java.util.ArrayDeque;
import java.util.Deque;

public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();

        int[] dailyTemperatures = new int[temperatures.length];

        int dailyTemperaturesIndex = dailyTemperatures.length - 1;

        while (dailyTemperaturesIndex >= 0) {
            Integer temperatureIndex = stack.peekLast();

            if (temperatureIndex != null && temperatures[temperatureIndex] > temperatures[dailyTemperaturesIndex]) {
                stack.addLast(dailyTemperaturesIndex);

                dailyTemperatures[dailyTemperaturesIndex] = temperatureIndex - dailyTemperaturesIndex;

                dailyTemperaturesIndex--;
            } else if (temperatureIndex != null && temperatures[temperatureIndex] <= temperatures[dailyTemperaturesIndex]) {
                stack.removeLast();
            } else {
                stack.add(dailyTemperaturesIndex);

                dailyTemperaturesIndex--;
            }
        }

        return dailyTemperatures;
    }
}
