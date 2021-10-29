class Solution {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        return (int)dfs(nums, 0, k, new Long[nums.length][k + 1]);
    }
    private long dfs(int[] nums, int p, int k, Long[][] dp) {
        if(p == nums.length) return 0;
        if(k < 0) return Integer.MAX_VALUE;
        if(dp[p][k] != null) return dp[p][k];
        long res = Integer.MAX_VALUE; 
        int sum = 0, max = nums[p];
        for(int j = p; j < nums.length; j++) {
            max = Math.max(max, nums[j]);
            sum += nums[j];
            int wasted = max * (j - p + 1) - sum;
            res = Math.min(res, dfs(nums, j + 1, k - 1, dp) + wasted);
        }
        return dp[p][k] = res;
    }
}