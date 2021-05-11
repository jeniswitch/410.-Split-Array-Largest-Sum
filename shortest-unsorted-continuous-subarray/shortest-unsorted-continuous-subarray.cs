public class Solution {
    private int min;
    private int max;
    public int FindUnsortedSubarray(int[] nums) {
        min = nums.Length;
        max = -1;
        MergeSort(nums, 0, nums.Length - 1);
        if(min > max) {
            return 0;
        }
        return max - min + 1;
    }
    private void MergeSort(int[] nums, int start, int end) {
        if(start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        MergeSort(nums, start, mid);
        MergeSort(nums, mid + 1, end);
        
        int left = start;
        int right = mid + 1;
        List<int> temp = new List<int>();
        while(left <= mid && right <= end) {
            //Console.WriteLine("left right " + left + " " + right);
            if(nums[left] <= nums[right]) {
                temp.Add(nums[left++]);
            }
            else {
                //Console.WriteLine("before " + min + " " + max);
                //Console.WriteLine("left right " + left + " " + right);
                min = Math.Min(min, left);
                max = Math.Max(max, right);
                Console.WriteLine(min + " " + max);
                temp.Add(nums[right++]);
            }
        }
        while(left <= mid) {
            temp.Add(nums[left++]);
        }
        while(right <= end) {
            temp.Add(nums[right++]);
        }
        int index = 0;
        for(int i = start; i <= end; i++) {
            nums[i] = temp[index++];
        }
    }
}