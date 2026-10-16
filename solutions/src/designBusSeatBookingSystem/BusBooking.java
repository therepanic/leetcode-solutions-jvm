package designBusSeatBookingSystem;


public class BusBooking {

    private final int[] rows;
    private final int[][] time;
    private int order;
    private int inorder;

    public BusBooking(int n) {
        this.rows = new int[n + 1];
        this.time = new int[n + 1][4];
    }

    public void toggle(String seat) {
        int s = seat.charAt(0) - 'A';
        int row = Integer.parseInt(seat.substring(1));
        if ((this.rows[row] & (1 << s)) != 0) {
            this.order -= this.time[row][s];
            this.rows[row] ^= (1 << s);
            this.inorder--;
            return;
        }
        if (s == 0 && (this.rows[row] & (1 << 1)) != 0 || s == 3 && (this.rows[row] & (1 << 2)) != 0) {
            this.time[row][s] = 3;
            this.order += 3;
        } else {
            this.time[row][s] = 1;
            this.order++;
        }
        this.inorder++;
        this.rows[row] |= (1 << s);
    }

    public int getTotalTime() {
        return this.order;
    }

    public int getMinTime() {
        return this.inorder;
    }
}

