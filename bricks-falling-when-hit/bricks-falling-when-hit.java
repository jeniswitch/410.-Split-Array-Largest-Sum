class Solution {
    private static final int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int rows = grid.length;
        int cols = grid[0].length;
        DisjointSet ds = new DisjointSet(rows * cols + 1);
        for(int[] hit : hits) {
            if(grid[hit[0]][hit[1]] == 1) {
                grid[hit[0]][hit[1]] = 2;
            }
        }
        
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                if(grid[i][j] == 1) {
                    unionAround(i, j, ds, grid);
                }
            }
        }
        
        int numleft = ds.s[ds.find(0)];
        int i = hits.length - 1;
        int[] res = new int[hits.length];
        while(i >= 0) {
            int x = hits[i][0];
            int y = hits[i][1];
            if(grid[x][y] == 2) {
                grid[x][y] = 1;
                unionAround(x, y, ds, grid);
                int nNumLeft = ds.s[ds.find(0)];
                res[i] = Math.max(nNumLeft - numleft - 1, 0);
                numleft = nNumLeft;
            }
            i--;
        }
        return res;
    }
    private void unionAround(int x, int y, DisjointSet ds, int[][] grid) {
        int crrPos = position(x, y, grid[0].length);
        for(int[] direction : directions) {
            int nx = x + direction[0];
            int ny = y + direction[1];
            if(nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == 1) {
                ds.union(crrPos, position(nx, ny, grid[0].length));
            }
        }
        if(x == 0) {
            ds.union(0, crrPos);
        }
    }
    private int position(int x, int y, int cols) {
        return x * cols + y + 1;
    }
    private class DisjointSet {
        int[] p, s;
        public DisjointSet(int n) {
            p = new int[n];
            s = new int[n];
            Arrays.fill(s, 1);
            for(int i = 0; i < n; i++) {
                p[i] = i;
            }
        }
        public int find(int x) {
            if(p[x] != x) p[x] = find(p[x]);
            return p[x];
        }
        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);
            if(px != py) {
                p[px] = py;
                s[py] += s[px];
            }
        }
    }
}