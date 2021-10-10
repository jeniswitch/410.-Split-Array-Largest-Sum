class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        int minIdx1 = -1, minIdx2 = -1;
        for(int i = 0; i< n; i++) {
            int pre1 = minIdx1, pre2 = minIdx2;
            minIdx1= minIdx2 = -1;
            for(int j = 0; j < k; j++) {
                if(j != pre1) {
                    costs[i][j] += pre1 < 0 ? 0 : costs[i - 1][pre1];
                }
                else {
                    costs[i][j] += pre2 < 0 ? 0 : costs[i - 1][pre2];
                }
                if(minIdx1 < 0 || costs[i][j] < costs[i][minIdx1]) {
                    minIdx2 = minIdx1;
                    minIdx1 = j;
                }
                else if(minIdx2 < 0 || costs[i][j] < costs[i][minIdx2]) {
                    minIdx2 = j;
                }
            }
        }
        return costs[n - 1][minIdx1];
    }
}
