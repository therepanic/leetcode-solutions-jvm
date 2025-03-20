package myCalendarI;

import java.util.TreeMap;

public class MyCalendar {

    private final TreeMap<Integer, Integer> interval;

    public MyCalendar() {
        this.interval = new TreeMap<>();
    }

    public boolean book(int startTime, int endTime) {
        Integer floor = interval.floorKey(startTime);
        Integer ceil = interval.ceilingKey(startTime);
        if ((floor == null || interval.get(floor) <= startTime) && (ceil == null || ceil >= endTime)) {
            interval.put(startTime, endTime);
            return true;
        }
        return false;
    }
}
