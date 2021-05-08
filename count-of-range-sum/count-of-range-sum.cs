public class Solution {
    private long[] sums;
    private int lower;
    private int upper;
    private int count;
    public int CountRangeSum(int[] nums, int lower, int upper) {
        sums = new long[nums.Length + 1];
        this.lower = lower;
        this.upper = upper;
        count = 0;
        for(int i = 1; i < sums.Length; i++) {
            sums[i] = sums[i - 1] + nums[i - 1];
        }
        MergeSort(0, nums.Length);
        return count;
    }
    private void MergeSort(int start, int end) {
        if(start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        int right = mid + 1;
        int low = mid + 1;
        int high = mid + 1;
        MergeSort(start, mid);
        MergeSort(mid + 1, end);
        List<long> temp = new List<long>();
        for(int i = start; i <= mid; i++) {
            while(low <= end && sums[low] - sums[i] < lower) {
                low++;
            }
            while(high <= end && sums[high] - sums[i] <= upper) {
                high++;
            }
            count += high - low;
            while(right <= end && sums[right] < sums[i]) {
                temp.Add(sums[right++]);
            }
            temp.Add(sums[i]);
        }
        while(right <= end) {
            temp.Add(sums[right++]);
        }
        int index = 0;
        for(int i = start; i <= end; i++) {
            sums[i] = temp[index++];
        }
    }
}