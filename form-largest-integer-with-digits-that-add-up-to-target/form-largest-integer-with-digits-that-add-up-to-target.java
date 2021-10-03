class Solution {
    public String largestNumber(int[] cost, int target) {
        int[] dp = new int[target + 1];//max digits to reach i
        for(int t = 1; t <= target; t++) {
            dp[t] = Integer.MIN_VALUE;
            for(int c = 0; c < cost.length; c++) {
                if(t >= cost[c]) {
                    dp[t] = Math.max(dp[t], dp[t - cost[c]] + 1);
                }
            }
        }
        if(dp[target] < 0) return "0";
        StringBuilder sb = new StringBuilder();
        for(int d = 8; d >= 0; d--) {
            while(target >= cost[d] && dp[target] == dp[target - cost[d]] + 1) {
                sb.append(d + 1);
                target -= cost[d];
            }
        }
        return sb.toString();
    }
}