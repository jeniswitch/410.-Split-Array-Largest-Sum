public class Solution {
    public int[][] Merge(int[][] intervals) {
        List<int[]> lst = new List<int[]>();
        intervals = intervals.OrderBy(k => k[0]).ToArray();
        for(int i = 0; i < intervals.Length; i++) {
            if(lst.Count == 0 || lst[lst.Count - 1][1] < intervals[i][0]) {
                lst.Add(intervals[i]);
            }
            else {
                lst[lst.Count - 1][1] = Math.Max(lst[lst.Count - 1][1], intervals[i][1]);
            }
        }
        return lst.ToArray();
    }
}