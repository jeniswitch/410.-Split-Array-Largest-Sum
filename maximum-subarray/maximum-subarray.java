/*
    [-2,1,-3,4,-1,2,1,-5,4]
     -2 1 -2 4  3 5 6  1 5
*/
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            dp[i] = nums[i] + Math.max(dp[i - 1], 0);
            max = Math.max(dp[i], max);
        }
        return max;
    }
}