package myCalendarII;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarTwo {

    private List<int[]> first;
    private List<int[]> second;
    public MyCalendarTwo() {
        this.first = new ArrayList<>();
        this.second = new ArrayList<>();
    }

    public boolean book(int startTime, int endTime) {
        for (int[] book : this.second) {
            if (startTime < book[1] && endTime > book[0]) {
                return false;
            }
        }
        for (int[] book : this.first) {
            if (startTime < book[1] && endTime > book[0]) {
                this.second.add(new int[] {Math.max(startTime, book[0]), Math.min(endTime, book[1])});
            }
        }
        this.first.add(new int[] {startTime, endTime});
        return true;
    }

}
