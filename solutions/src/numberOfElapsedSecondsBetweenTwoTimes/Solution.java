class Solution {
    public int secondsBetweenTimes(String startTime, String endTime) {
        var a = startTime.split("\\:");
        var b = endTime.split("\\:");
        int ans = (Integer.parseInt(b[0]) - Integer.parseInt(a[0])) * 3600 + ((Integer.parseInt(b[1]) - Integer.parseInt(a[1])) * 60) + ((Integer.parseInt(b[2]) - Integer.parseInt(a[2])));
        return ans;
    }
}
