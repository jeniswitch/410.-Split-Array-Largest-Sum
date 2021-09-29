class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(sum < target || -sum > target || (sum + target) % 2 > 0) return 0;
        int s = (sum + target) >>> 1;
        int[][] dp = new int[nums.length + 1][s + 1];
        //number of subsets that can sum to j wiht frist i elements
        dp[0][0] = 1;
        for(int i = 1; i <= nums.length; i++) {
            for(int j = 0; j <= s; j++) {
                 if (j >= nums[i - 1]) {
                 dp[i][j] = dp[i - 1][j] + dp[i - 1][j - nums[i - 1]]; 
                 } else {
                     dp[i][j] = dp[i - 1][j];
                 }    
            }
        }
        return dp[nums.length][s];
    }
    
}