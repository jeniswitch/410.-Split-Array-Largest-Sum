class Solution {
    private Queue<int[]> q;
    public int shortestBridge(int[][] grid) {
        q = new LinkedList<int[]>();
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        boolean found = false;
        for(int i = 0; i < m; i++) {
            if(found) break;
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    dfs(grid, i, j, visited);
                    found = true;
                    break;
                }
            }
        }
        int step = 0;
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int[] p = q.poll();
                for(int i = 0; i < dir.length; i++) {
                    int x = p[0] + dir[i][0];
                    int y = p[1] + dir[i][1];
                    if(x < 0 || y < 0 || x == m || y == n || visited[x][y]) {
                        continue;
                    }
                    if(grid[x][y] == 1) {
                        return step;
                    }
                    q.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
            step++;
        }
        return step;
    }
    private void dfs(int[][] grid, int x, int y, boolean[][] visited) {
        if(x < 0 || y < 0 || x == grid.length || y == grid[0].length || grid[x][y] == 0 || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        q.offer(new int[]{x, y});
        dfs(grid, x, y + 1, visited);
        dfs(grid, x, y - 1, visited);
        dfs(grid, x + 1, y, visited);
        dfs(grid, x - 1, y, visited);
    }
}