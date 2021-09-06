class Solution {
    public int numDistinctIslands(int[][] grid) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, "");
                    String str = sb.toString();
                    if(!set.contains(str)) {
                        set.add(str);
                    }
                }
            }
        }
        return set.size();
    }
    private void dfs(int[][] grid, int i, int j, StringBuilder sb, String str) {
        if(i < 0 | j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 0) return;
        grid[i][j] = 0;
        sb.append(str);
        dfs(grid, i - 1, j, sb, "u");
        dfs(grid, i, j + 1, sb, "r");
        dfs(grid, i + 1, j , sb, "d");
        dfs(grid, i, j - 1, sb, "l");
        sb.append("b");
    }
}