class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][][] dp = new int[n][n][27];
        for(int i = n - 1; i >= 0; i--) {
            for(int j = i + 1; j < n; j++) {
                //if(i >= j) continue;
                char si = s.charAt(i);
                char sj = s.charAt(j);
                for(int pre = 0; pre < 27; pre++) {
                    if(si - 'a' == pre) {
                        dp[i][j][pre] = dp[i + 1][j][pre];
                        continue;
                    }
                    if(sj - 'a' == pre) {
                        dp[i][j][pre] = dp[i][j - 1][pre];
                        continue;
                    }
                    if(s.charAt(i) == s.charAt(j)) {
                        dp[i][j][pre] = dp[i + 1][j - 1][si - 'a'] + 2;
                    }
                    else {
                        dp[i][j][pre] = Math.max(dp[i + 1][j][pre] , dp[i][j - 1][pre]);
                    }
                }
            }
        }
        return dp[0][n - 1][26];
    }
}