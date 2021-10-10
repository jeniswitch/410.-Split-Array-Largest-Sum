class Solution {
    public int minCostII(int[][] costs) {
        for(int house = 1; house < costs.length; house++) {
            for(int c = 0; c < costs[0].length; c++) {
                int min = Integer.MAX_VALUE;
                for(int k = 0; k < costs[0].length; k++) {
                    if(c != k) {
                        min = Math.min(min, costs[house - 1][k]);
                    }
                }
                costs[house][c] += min;
            }
        }
        int min = Integer.MAX_VALUE;
        for(int c : costs[costs.length - 1]) {
            min = Math.min(min, c);
        }
        return min;
    }
}
