package CheckIfNumberIsASumOfPowersOfThree;

public class CheckIfNumberIsASumOfPowersOfThree {
    public boolean checkPowersOfThree(int n) {
        String nStr = Integer.toString(n, 3);
        return !nStr.contains("2");
    }
}
