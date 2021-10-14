class Solution {
    public int twoEggDrop(int n) {
        return drop(n, 2, new int[n + 1][3]);
    }
    private int drop(int floor, int eggs, int[][] dp) {
        if(eggs == 1 || floor <= 1) {
            return floor;
        }
        if(dp[floor][eggs] > 0) return dp[floor][eggs];
        int min = Integer.MAX_VALUE;
        for(int f = 1; f <= floor; f++) {
            min = Math.min(min, 1 + Math.max(drop(f - 1, eggs - 1, dp), drop(floor - f, eggs, dp)));
        }
        return dp[floor][eggs] = min;
    }
}