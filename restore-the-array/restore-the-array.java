class Solution {
    private final long MOD = (long)1e9 + 7;
    public int numberOfArrays(String s, int k) {
        Integer[] dp = new Integer[s.length()];
        return dfs(s, k, 0, dp);
    }
    private int dfs(String s, int k, int i, Integer[] dp) {
        if(i == s.length()) return 1;
        if(s.charAt(i) == '0') return 0;
        if(dp[i] != null) return dp[i];
        long count = 0;
        long num = 0;
        for(int j = i; j < s.length(); j++) {
            num = num * 10 + s.charAt(j) - '0';
            if(num > k) break;
            count += dfs(s, k, j + 1, dp);
            count %= MOD;
        }
        return dp[i] = (int)count;
    }
}