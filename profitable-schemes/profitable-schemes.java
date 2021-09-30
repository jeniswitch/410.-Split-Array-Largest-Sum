class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        int N = (int)1e9 + 7, res = 0;
        int[][] dp = new int[minProfit + 1][n + 1];
        dp[0][0] = 1;
        for(int i = 0; i < group.length; i++) {
            int g = group[i], p = profit[i];
            for(int j = minProfit; j >= 0; j--) {
                for(int k = n - g; k >= 0; k--) {
                    dp[Math.min(j + p, minProfit)][k + g] = (dp[Math.min(j + p, minProfit)][k + g] + dp[j][k]) % N;
                }
            }
        }
        for(int d : dp[minProfit]) {
            res = (res + d) % N;
        }
        return res;
    }
}