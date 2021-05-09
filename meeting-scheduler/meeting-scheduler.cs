public class Solution {
    public IList<int> MinAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        Array.Sort(slots1, (x, y) => {return x[0] - y[0];});
        Array.Sort(slots2, (x, y) => {return x[0] - y[0];});

        int p1 = 0;
        int p2 = 0;
        while(p1 < slots1.Length && p2 < slots2.Length) {
            int left = Math.Max(slots1[p1][0], slots2[p2][0]);
            int right = Math.Min(slots1[p1][1], slots2[p2][1]);
            if(right - left >= duration) {
                return new List<int>(){left, left + duration};
            }
            if(slots1[p1][1] < slots2[p2][1]) {
                p1++;
            }
            else {
                p2++;
            }
        }
        return new List<int>();
    }
}