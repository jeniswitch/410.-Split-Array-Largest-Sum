public class Solution {
    public int MinMeetingRooms(int[][] intervals) {
        Array.Sort(intervals, (x, y) => {return x[0] - y[0];});
        var ss = new SortedSet<int>();
        ss.Add(intervals[0][1]);
        int dup = 0;
        for(int i = 1; i < intervals.Length; i++) {
            if(intervals[i][0] >= ss.Min) {
                ss.Remove(ss.Min);
            }
            if(ss.Contains(intervals[i][1])) {
                dup++;
            }
            else {
                ss.Add(intervals[i][1]);
            }
        }
        return ss.Count + dup;
    }
}