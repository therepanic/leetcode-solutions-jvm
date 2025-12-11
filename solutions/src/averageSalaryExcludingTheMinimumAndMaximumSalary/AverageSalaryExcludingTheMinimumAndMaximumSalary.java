package averageSalaryExcludingTheMinimumAndMaximumSalary;

public class AverageSalaryExcludingTheMinimumAndMaximumSalary {
    public double average(int[] salary) {
        long sum = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < salary.length; i++) {
            min = Math.min(salary[i], min);
            max = Math.max(salary[i], max);
        }
        for (int i = 0; i < salary.length; i++) {
            if (salary[i] != min && salary[i] != max) {
                sum += salary[i];
            }
        }
        return (double) sum / (salary.length - 2);
    }
}
