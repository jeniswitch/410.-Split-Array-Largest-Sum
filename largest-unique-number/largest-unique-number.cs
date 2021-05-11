public class Solution {
    public int LargestUniqueNumber(int[] A) {
        SortedList<int, int> sl = new SortedList<int, int>();
        for(int i = 0; i < A.Length; i++) {
            if(sl.ContainsKey(A[i])) {
                sl[A[i]]++;
            }
            else {
                sl[A[i]] = 1;
            }
        }
        while(sl.Count > 0 && sl.Values.Last() > 1) {
            sl.Remove(sl.Keys.Last());
        }
        if(sl.Count > 0) {
            return sl.Keys.Last();
        }
        return -1;
    }
}