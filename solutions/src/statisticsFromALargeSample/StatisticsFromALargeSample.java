package statisticsFromALargeSample;

public class StatisticsFromALargeSample {
    public double[] sampleStats(int[] count) {
        int normal = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        double median = 0;
        int value = 0;
        int valueC = count[0];
        double mean = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                if (count[i] > valueC) {
                    value = i;
                    valueC = count[i];
                }
                normal += count[i];
                min = Math.min(i, min);
                max = Math.max(i, max);
            }
        }
        for (int i = 0; i < count.length; i++) {
            if (count[i] > 0) {
                mean += ((double) i * count[i]) / (double) normal;
            }
        }
        if (normal % 2 == 0) {
            for (int i = 0, j = 0; i < count.length; i++) {
                if (count[i] > 0) {
                    if (j - 1 < normal / 2 - 1) {
                        j += count[i];
                        if (j - 1 >= normal / 2 - 1) {
                            median = i;
                        }
                        if (j - 1 >= normal / 2) {
                            median = (median + i) / 2;
                            break;
                        }
                    } else if (j - 1 < normal / 2) {
                        j += count[i];
                        if (j - 1 >= normal / 2) {
                            median = (median + i) / 2;
                            break;
                        }
                    }
                }
            }
        } else {
            for (int i = 0, j = 0; i < count.length; i++) {
                if (count[i] > 0) {
                    if (j <= normal / 2) {
                        j += count[i];
                        if (j > normal / 2) {
                            median = i;
                            break;
                        }
                    }
                }
            }
        }
        return new double[] {min, max, mean, median, value};
    }
}
