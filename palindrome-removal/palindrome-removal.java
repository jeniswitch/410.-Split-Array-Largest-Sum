class Solution {
    private int[][] dp;
    public int minimumMoves(int[] arr) {
        int n = arr.length;
        dp = new int[n][n];
        return dfs(arr, 0, n - 1);
    }
    private int dfs(int[] arr, int i, int j) {
        if(i > j) return 0;
        if(dp[i][j] > 0) return dp[i][j];
        int res = dfs(arr, i, j - 1) + 1;
        if(j > 0 && arr[j - 1] == arr[j]) {
            res = Math.min(res, dfs(arr, i, j - 2) + 1);
        }
        for(int k = i; k < j - 1; k++) {
            if(arr[k] == arr[j]) {
                res = Math.min(res, dfs(arr, i, k - 1) + dfs(arr, k + 1, j - 1));
            }
        }
        return dp[i][j] = res;
    }
}