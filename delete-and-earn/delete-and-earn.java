class Solution {
    public int deleteAndEarn(int[] nums) {
        int[] buckets = new int[10001];
        for(int n : nums) {
            buckets[n] += n;
        }
        int[] dp = new int[10001];//max number of points in the first i + 1 buckets
        dp[0] = 0;
        dp[1] = buckets[1];
        for(int i = 2; i <= 10000; i++) {
            dp[i] = Math.max(dp[i - 2] + buckets[i], dp[i - 1]);
        }
        return dp[10000];
    }
}