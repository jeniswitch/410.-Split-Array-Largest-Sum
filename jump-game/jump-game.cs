public class Solution {
    public bool CanJump(int[] nums) {
        int lastPos = nums.Length - 1;
        for(int i = lastPos; i >= 0; i--) {
            if(i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }
}