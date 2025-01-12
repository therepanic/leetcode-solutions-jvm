package findTheStudentThatWillReplaceTheChalk;

public class FindTheStudentThatWillReplaceTheChalk {
    public static int chalkReplacer(int[] chalk, int k) {
        long d = k;
        long[] chalks = new long[chalk.length];
        chalks[0] = chalk[0];
        for (int i = 1; i < chalks.length; i++) {
            chalks[i] = chalk[i] + chalks[i - 1];
        }
        int pointer = chalks.length - 1;
        d %= chalks[pointer];
        for (int i = 0; i < chalks.length; i++) {
            if (d - chalks[i] < 0) {
                return i;
            }
        }
        return 0;
    }
}
