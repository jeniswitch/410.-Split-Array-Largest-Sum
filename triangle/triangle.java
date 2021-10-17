class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        Integer[][] memo = new Integer[triangle.size()][triangle.size()];
        dfs(triangle, 0, 0, memo);
        return memo[0][0];
    }
    private int dfs(List<List<Integer>> t, int row, int col, Integer[][] memo) {
        if(row == t.size() - 1 && col < t.size()) return memo[row][col] = t.get(row).get(col);
        if(row == t.size() ||col == t.size()) return 0;
        if(memo[row][col] != null) return memo[row][col];
        int crr = t.get(row).get(col);
        memo[row][col] = Math.min(dfs(t, row + 1, col, memo) + crr, dfs(t, row + 1, col + 1, memo) + crr);
        return memo[row][col];
    }
}