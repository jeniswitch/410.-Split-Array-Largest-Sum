class Solution {
    public int minSkips(int[] dist, int speed, int hoursBefore) {
        int n = dist.length;
        if(n == 1) {
            return 0;
        }
        long[] sum = new long[n];
        sum[0] = (long)dist[0];
        for(int i = 1; i < dist.length; i++) {
            sum[i] += sum[i - 1] + (long)dist[i];
        }
        if(sum[n - 1] > (long)speed * hoursBefore) {
            return -1;
        }
       
        long[][] dp = new long[n][n];
        for(int i = 0; i < n; i++) {
            long temp = dist[i] % speed == 0 ? (long)dist[i] : ((long)dist[i] / speed + 1) * speed;
            if(i == 0) {
                dp[i][0] = temp;
            }
            else {
                dp[i][0] = dp[i - 1][0] + temp;
            }
        }
        for(int j = 1; j < n; j++) {
            for(int i = j - 1; i < n - 1; i++) {
                if(i == j - 1) {
                    dp[i][j] = sum[i];
                }
                else {
                    long opt = (dp[i - 1][j] + (long)dist[i]) % speed == 0 ? dp[i - 1][j] + (long)dist[i] : ((dp[i - 1][j] + (long)dist[i]) / speed + 1) * speed;
                    dp[i][j] = Math.min(opt, dp[i - 1][j - 1] + (long)dist[i]);
                }
            }
        }
        for(int j = 0; j < n ; j++) {
            if(dp[n - 2][j] + (long)dist[n - 1] <= (long)speed * hoursBefore) {
                return j;
            }
        }
        return -1;
    }
}