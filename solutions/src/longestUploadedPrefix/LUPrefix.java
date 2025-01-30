package longestUploadedPrefix;

public class LUPrefix {
    private final boolean[] arr;
    private int pointer;
    public LUPrefix(int n) {
        this.arr = new boolean[n];
        this.pointer = 0;
    }

    public void upload(int video) {
        arr[video - 1] = true;
        while (pointer < arr.length && arr[pointer]) {
            pointer++;
        }
    }

    public int longest() {
        return pointer;
    }
}
