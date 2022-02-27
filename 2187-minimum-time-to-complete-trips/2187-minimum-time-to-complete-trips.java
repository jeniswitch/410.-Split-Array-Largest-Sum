class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        if(time.length == 1) {
            return (long)time[0] * totalTrips;
        }
        //Arrays.sort(time);
        int min = time[0];
        for(int t : time) {
            min = Math.min(min, t);
        }
        long start = min, end = start * totalTrips;
        while(start < end) {
            long mid = start + (end - start) / 2;
            if(check(time, mid) < totalTrips) {
                start = mid + 1;
            }
            else {
                end = mid;
            }
        }
        return start;
    }
    private long check(int[] time, long t) {
        long count = 0;
        for(int i = 0; i < time.length; i++) {
            count += t / (long)time[i];
        }
        return count;
    }
}