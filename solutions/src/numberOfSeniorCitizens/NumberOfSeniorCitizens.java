package numberOfSeniorCitizens;

public class NumberOfSeniorCitizens {
    public int countSeniors(String[] details) {
        int seniorsCount = 0;

        for (String detail : details) {
            if (Integer.parseInt(detail.substring(detail.length() - 4, detail.length() - 2)) > 60) {
                seniorsCount++;
            }
        }

        return seniorsCount;
    }
}
