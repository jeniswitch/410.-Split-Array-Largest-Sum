class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = scores.length;
        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            arr[i][0] = ages[i];
            arr[i][1] = scores[i];
        }
        Arrays.sort(arr, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        int[] dp = new int[n];
        dp[0] = arr[0][1];
        int max = dp[0];
        for(int i = 1; i < n; i++) {
            dp[i] = arr[i][1];
            for(int j = 0; j < i; j++) {
                if(arr[j][1] <= arr[i][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + arr[i][1]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}