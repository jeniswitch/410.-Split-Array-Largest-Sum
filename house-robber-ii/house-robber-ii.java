class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        if(n == 2) return Math.max(nums[0], nums[1]);
        if(n == 3) return Math.max(nums[0], Math.max(nums[1], nums[2]));
        int[][] dp = new int[n + 1][2];//max money of robbing first n hourses with robing or not robbing 1st house(0 or 1);
        dp[1][0] = 0;
        dp[1][1] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            dp[i + 1][0] = Math.max(dp[i - 1][0] + nums[i], dp[i][0]);
            if(i == nums.length - 1) {
                dp[i + 1][1] = dp[i][1];
            }
            else {
                dp[i + 1][1] = Math.max(dp[i - 1][1] + nums[i], dp[i][1]);
            }
        }
        return Math.max(dp[n][0], dp[n][1]);
    }
}