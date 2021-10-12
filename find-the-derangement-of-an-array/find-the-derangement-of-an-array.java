class Solution {
    public int findDerangement(int n) {
        if(n < 2) return n - 1; 
        long[] dp = new long[n + 1];
        long mod = (long)1e9 + 7L;
        dp[2] = 1;
        for(int i = 3; i <= n; i++) {
            dp[i] = (i - 1) * (dp[i - 1] + dp[i -2]) % mod;;
        }
        return (int)dp[n];
    }
}