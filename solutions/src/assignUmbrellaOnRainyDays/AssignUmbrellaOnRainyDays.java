package assignUmbrellaOnRainyDays;

public class AssignUmbrellaOnRainyDays {
    public String[] assignUmbrella(int[] rain) {
        String[] ans = new String[rain.length];
        int a = 0;
        int b = 0;
        for (int i = 0; i < rain.length; i++) {
            boolean alice = false;
            boolean bob = false;
            if (i + 1 < rain.length && rain[i] == rain[i + 1] && rain[i] == 1) {
                alice = true;
            }
            if (rain[i] == 1) {
                bob = true;
            }
            if (alice && bob) {
                if (a > b) {
                    b++;
                    ans[i] = "Bob";
                } else {
                    a++;
                    ans[i] = "Alice";
                }
            } else if (bob) {
                b++;
                ans[i] = "Bob";
            } else if (!alice) {
                ans[i] = "None";
            }
        }
        return ans;
    }
}
