class Solution {
    public int minCostII(int[][] costs) {
        int[][] dp = new int[costs.length][costs[0].length];
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < costs[0].length; j++) {
            min = Math.min(min, dfs(costs, 0, j, dp));
        }
        return min;
    }
    private int dfs(int[][] costs, int i, int j, int[][] dp) {
        if(i == costs.length - 1) return costs[i][j];
        if(dp[i][j] > 0) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k = 0; k < costs[0].length; k++) {
            if(k != j) {
                min = Math.min(min, dfs(costs, i + 1, k, dp));
            }
        }
        return dp[i][j] = costs[i][j] + min;
    }
}