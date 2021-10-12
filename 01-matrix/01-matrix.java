class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] dp = new int[m][n];
        int MAX = m + n;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0){
                    continue;
                } 
                int top = MAX, left = MAX;
                if(i > 0) top = dp[i - 1][j];
                if(j > 0) left = dp[i][j - 1];
                dp[i][j] = Math.min(top, left) + 1;
            }
        }
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int btm = MAX, right = MAX;
                if(i < m - 1) btm = dp[i + 1][j];
                if(j < n - 1) right = dp[i][j + 1];
                dp[i][j] = Math.min(dp[i][j], Math.min(btm, right) + 1);
            } 
        }
        return dp;
    }
}