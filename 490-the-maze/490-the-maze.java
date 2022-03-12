class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        return dfs(maze, start, destination);
    }
    private boolean dfs(int[][] maze, int[] crr, int[] d) {
        int x = crr[0];
        int y = crr[1];
        if(maze[x][y] == -1) return false;
        if(x == d[0] && y == d[1]) return true;
        int tempx = x;
        maze[x][y] = -1;
        while(x - 1 >= 0 && maze[x - 1][y] != 1) {
            x--;
        }
        if(dfs(maze, new int[]{x, y}, d)) return true;
        x = crr[0];
        while(x + 1 < maze.length && maze[x + 1][y] != 1) {
            x++;
        }
        if(dfs(maze, new int[]{x, y}, d)) return true;
        x = crr[0];
        while(y - 1 >= 0 && maze[x][y - 1] != 1) {
            y--;
        }
        if(dfs(maze, new int[]{x, y}, d)) return true;
        y = crr[1];
        while(y + 1 < maze[0].length && maze[x][y + 1] != 1) {
            y++;
        }
        if(dfs(maze, new int[]{x, y}, d)) return true;
        return false;
    }
}