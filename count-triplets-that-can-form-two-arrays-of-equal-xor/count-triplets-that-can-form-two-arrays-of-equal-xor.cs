public class Solution {
    public int CountTriplets(int[] arr) {
        var count = new Dictionary<int, int>();//prefixsum, count
        var sumIndex = new Dictionary<int, int>();//prefixsum, sumindex
        int prefixSum = 0;
        count[prefixSum] = 1;
        sumIndex[prefixSum] = -1;
        int res = 0;
        for(int i = 0; i < arr.Length; i++) {
            prefixSum ^= arr[i];
            int c = 0;
            int s = 0;
            if(count.ContainsKey(prefixSum)) {
                c = count[prefixSum];
                s = sumIndex[prefixSum];
                res += (i - 1) * c - s;
            }
            count[prefixSum] = c + 1;
            sumIndex[prefixSum] = s + i;
        }
        return res;
    }
}
