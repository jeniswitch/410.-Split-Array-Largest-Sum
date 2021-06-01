public class Solution {
    public int SpecialArray(int[] nums) {
        Array.Sort(nums);
        for(int i = 0; i < nums.Length; i++) {
            int n = nums.Length - i;
            if(n <= nums[i] && (i == 0 || n > nums[i - 1])) {
                return n;
            }
        }
        return -1;
    }
}
