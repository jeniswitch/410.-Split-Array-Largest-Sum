class Solution {
    public int fib(int n) {
        int[] dp = new int[n + 1];
        return f(n, dp);
    }
    private int f(int n, int[] dp) {
        if(n < 2) return n;
        if(dp[n] > 0) return dp[n];
        dp[n] = f(n - 1, dp) + f(n - 2, dp);
        return dp[n];
    }
}