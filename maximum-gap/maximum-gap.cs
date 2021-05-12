public class Solution {
    public int MaximumGap(int[] nums) {
        if(nums.Length < 2) {
            return 0;
        }
        int[] clone = new int[nums.Length];
        Array.Copy(nums, clone, nums.Length);
        Array.Sort(clone);
        int max = 0;
        for(int i = 1; i < clone.Length; i++) {
            max = Math.Max(clone[i]- clone[i - 1], max);
        }
        return max;
    }
}