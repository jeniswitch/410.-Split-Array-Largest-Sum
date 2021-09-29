class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        if(sum < target || -sum > target || (sum + target) % 2 > 0) return 0;
        int s = (sum + target) >>> 1;
        int[] dp = new int[s + 1];
        //number of subsets that can sum to j wiht frist i elements
        dp[0] = 1;
        for(int i = 1; i <= nums.length; i++) {
            for(int j = s; j >= nums[i - 1]; j--) {
                dp[j] += dp[j - nums[i - 1]];
            }
        }
        return dp[s];
    }
    
}
