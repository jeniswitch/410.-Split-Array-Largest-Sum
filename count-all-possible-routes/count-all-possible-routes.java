class Solution {
    private final long mod = (long)1e9 + 7;
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        long[][] dp = new long[locations.length][fuel + 1];
        for(int i = 0; i < locations.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return (int)dfs(locations, start, finish, fuel, dp);
    }
    private long dfs(int[] locations, int crr, int e, int fuel, long[][] dp) {
        if(fuel < 0) return 0;
        if(dp[crr][fuel] != -1) return dp[crr][fuel];
        long count = crr == e ? 1 : 0;
        for(int i = 0; i < locations.length; i++) {
            if(i != crr) {
                count = (count + dfs(locations, i, e, fuel - Math.abs(locations[i] - locations[crr]), dp)) % mod;
            }
        }
        return dp[crr][fuel] = count;
    }
}