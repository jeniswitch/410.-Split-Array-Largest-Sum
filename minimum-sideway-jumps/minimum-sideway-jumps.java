class Solution {
    public int minSideJumps(int[] obstacles) {
        int[] dp = new int[]{1, 0, 1};
        for(int c : obstacles) {
            if(c > 0) {
                dp[c - 1] = 1000000;
            }
            for(int i = 0; i < 3; i++) {
                if(i != c - 1) {
                    int laneNext = (i + 1) % 3;
                    int laneNextNext = (i + 2) % 3;
                    dp[i] = Math.min(dp[i], Math.min(dp[laneNext], dp[laneNextNext]) + 1);
                }
            }
        }
        return Math.min(dp[0], Math.min(dp[1], dp[2]));
    }
}