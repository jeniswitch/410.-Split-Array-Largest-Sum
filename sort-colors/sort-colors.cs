public class Solution {
    public void SortColors(int[] nums) {
        QuickSort(nums, 0, nums.Length - 1);
    }
    private void QuickSort(int[] nums, int l, int r) {
        if(l >= r) return;
        int i = l - 1;
        int j = r + 1;
        int x = nums[l + (r - l) / 2];
        while(i < j) {
            do{
                i++;
            }
            while(nums[i] < x);
            do{
                j--;
            }
            while(nums[j] > x);
            if(i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        QuickSort(nums, l, j);
        QuickSort(nums, j + 1, r);
    }
}