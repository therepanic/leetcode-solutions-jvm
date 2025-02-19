package walkingRobotSimulationII;

public class Robot {
    private final int width;
    private final int height;
    private int p;

    public Robot(int width, int height) {
        this.width = width - 1;
        this.height = height - 1;
    }

    public void step(int num) {
        p += num;
    }

    public int[] getPos() {
        int steps = p % (2 * (width + height));
        if (steps <= width) {
            return new int[] {steps, 0};
        }
        steps -= width;
        if (steps <= height) {
            return new int[] {width, steps};
        }
        steps -= height;
        if (steps <= width) {
            return new int[] {width - steps, height};
        }
        steps -= width;
        return new int[] {0, height - steps};
    }

    public String getDir() {
        int[] pos = getPos();
        if (p == 0 || pos[1] == 0 && pos[0] > 0)
            return "East";
        else if (pos[0] == width && pos[1] > 0)
            return "North";
        else if (pos[1] == height && pos[0] < width)
            return "West";
        else
            return "South";
    }
}
