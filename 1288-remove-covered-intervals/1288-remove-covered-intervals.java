class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> b[1] == a[1] ? (a[0] - b[0]) : (b[1] - a[1]));
        int[] last = intervals[0];
        int res = intervals.length;
        for(int i = 1; i < intervals.length; i++) {
            if(intervals[i][0] >= last[0] && intervals[i][0] <= last[1]) {
                res--;
            }
            else {
                last = intervals[i];
            }
        }
        return res;
    }
}