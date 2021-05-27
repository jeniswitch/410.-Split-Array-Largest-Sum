public class Solution {
    public int GetMaxLen(int[] nums) {
        int pos0 = -1;
        int pos1stNeg = -1;
        int countNeg = 0;
        int max = 0;
        for(int i = 0; i < nums.Length; i++) {
            if(nums[i] == 0) {
                pos0 = i;
                pos1stNeg = -1;
                countNeg = 0;
            }
            else if(nums[i] < 0) {
                countNeg++;
                if(pos1stNeg < 0) {
                    pos1stNeg = i;
                }
            }
            if(nums[i] != 0) {
                max = countNeg % 2 == 0 ? Math.Max(i - pos0, max) : Math.Max(i - pos1stNeg, max);
            }
        }
        return max;
    }
}