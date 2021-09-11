class Solution {
    private int[] p;
    private int[] size;
    private int[][] grid;
    private final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length;
        int n = grid[0].length;
        p = new int[m * n + 1];
        size = new int[p.length];
        Arrays.fill(size, 1);
        for(int i = 0; i < p.length; i++) {
            p[i] = i;
        }
        this.grid = grid;
        for(int[] h : hits) {
            int x = h[0];
            int y = h[1];
            if(grid[x][y] == 1) {
                grid[x][y] = 2;
            }
        }
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid[i][j] == 1) {
                    unionAround(i, j);
                }
            }
        }
        int left = size[find(0)];
        int[] res = new int[hits.length];
        for(int i = hits.length - 1; i >= 0; i--) {
            int x = hits[i][0];
            int y = hits[i][1];
            if(grid[x][y] == 2) {
                grid[x][y] = 1;
                unionAround(x, y);
                int newLeft = size[find(0)];
                res[i] = Math.max(newLeft - left - 1, 0);
                left = newLeft;
            }
        }
        return res;
    }
    private int find(int x) {
        if(x != p[x]) p[x] = find(p[x]);
        return p[x];
    }
    private int getPosition(int i, int j) {
        return i * grid[0].length + j + 1;
    }
    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if(px != py) {
            p[px] = py;
            size[py] += size[px];
        }
    }
    private void unionAround(int i, int j) {
        int crr = getPosition(i, j);
        for(int k = 0; k < dir.length; k++) {
            int x = i + dir[k][0];
            int y = j + dir[k][1];
            if(x >= 0 && y >= 0 && x < grid.length && y < grid[0].length && grid[x][y] == 1)             {
                union(crr, getPosition(x, y));
            }
        }
        if(i == 0) {
            union(0, crr);
        }
    }
}