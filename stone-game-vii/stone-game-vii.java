class Solution {
    private Integer[][] dp;
    private int[] prefixSum;
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        dp = new Integer[n][n];
        prefixSum = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + stones[i - 1];
        }
        return helper(0, n - 1);
    }
    private int getSum(int left, int right) {
        return prefixSum[right + 1] - prefixSum[left];
    }
    private int helper(int left, int right) {
        if(left == right) return 0;
        if(dp[left][right] != null) return dp[left][right];
        int res = Math.max(getSum(left + 1, right) - helper(left + 1, right), getSum(left, right - 1) - helper(left, right - 1));
        return dp[left][right] = res;
    }
}