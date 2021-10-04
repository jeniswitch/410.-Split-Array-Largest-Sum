class Solution {
    public boolean splitArraySameAverage(int[] nums) {
        int sum = 0;
        for(int n : nums) {
            sum += n;
        }
        boolean[][] dp = new boolean[sum + 1][nums.length / 2 + 1];
        dp[0][0] = true;
        for(int n : nums) {
            for(int s = sum; s >= n; s--) {
                for(int l = 1; l <= nums.length / 2; l++) {
                    dp[s][l] = dp[s][l] || dp[s - n][l - 1];
                }   
            }
        }
        for(int i = 1; i <= nums.length / 2; i++) {
            if(sum * i % nums.length == 0 && dp[sum * i / nums.length][i]) return true;
        }
        return false;
    }
}