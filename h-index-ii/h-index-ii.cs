public class Solution {
    public int HIndex(int[] citations) {
        int start = 0;
        int end = citations.Length - 1;
        int n = citations.Length;
        while(start <= end) {
            int mid = start + (end - start) / 2;
            if(citations[mid] == n - mid) {
                return citations[mid];
            }
            else if(citations[mid] < n - mid) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return n - start;
    }
}