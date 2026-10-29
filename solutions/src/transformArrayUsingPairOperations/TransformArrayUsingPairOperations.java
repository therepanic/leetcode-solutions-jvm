package transformArrayUsingPairOperations;

public class TransformArrayUsingPairOperations {
    public boolean canTransform(int[] source, int[] target) {
        long a = 0, b = 0;
        for (int i = 0; i < source.length; i++) {
            a += source[i];
            b += target[i];
        }
        return a == b;
    }
}
