package maximumNumberOfGroupsEnteringACompetition;

public class MaximumNumberOfGroupsEnteringACompetition {
    public int maximumGroups(int[] grades) {
        int total = 0;
        int k = 0;

        while (total + k + 1 <= grades.length) {
            k++;

            total += k;
        }

        return k;
    }
}
