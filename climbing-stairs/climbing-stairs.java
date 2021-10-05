class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 1;
        for(int i = 1; i < n; i++) {
            dp[i + 1] = dp[i - 1] + dp[i];
        }
        return dp[n];
    }
}