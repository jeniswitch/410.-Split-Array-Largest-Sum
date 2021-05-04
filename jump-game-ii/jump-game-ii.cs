public class Solution {
    public int Jump(int[] nums) {
        int farthestPos = 0;
        int end = 0;
        int count = 0;
        for(int i = 0; i < nums.Length - 1; i++) {
            farthestPos = Math.Max(farthestPos, nums[i] + i);
            if(i == end) {
                end = farthestPos;
                count++;
            }
        }
        return count;
    }
}