class Solution {
    private final static int[][] d = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    private int m, n;
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        m = maze.length;
        n = maze[0].length;
        return dfs(maze, start, destination, new boolean[m][n]);
    }
    private boolean dfs(int[][] maze, int[] p, int[] des, boolean[][] visited) {
        if(p[0] == des[0] && p[1] == des[1]) {
            return true;
        }
        if(visited[p[0]][p[1]]) {
            return false;
        }
        visited[p[0]][p[1]] = true;
        for(int i = 0; i < d.length; i++) {
            int r = p[0];
            int c = p[1];
            while(isValid(r, c, maze)) {
                r += d[i][0];
                c += d[i][1];
            }
            if(dfs(maze, new int[]{r - d[i][0], c - d[i][1]}, des, visited)) {
                return true;
            }
        }
        return false;
    }
    private boolean isValid(int r, int c, int[][] maze) {
        return r >= 0 && r < m && c >= 0 && c < n && maze[r][c] == 0;
    }
}