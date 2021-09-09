class Solution {
    public int latestDayToCross(int row, int col, int[][] cells) {
        int l = 0, r = cells.length - 1;
        while(l < r) {
            int mid = l + r + 1 >> 1;
            if(check(row, col, mid, cells)) {
                l = mid;
            }
            else {
                r = mid - 1;
            }
        }
        return l + 1;
    }
    private boolean check(int r, int c, int mid, int[][] cells) {
        int[][] grid = new int[r][c];
        for(int i = 0; i <= mid; i++) {
            grid[cells[i][0] - 1][cells[i][1] - 1] = 1;
        }
        Queue<int[]> q = new LinkedList<int[]>();
        for(int i = 0; i < c; i++) {
            if(grid[0][i] == 0) {
                q.offer(new int[]{0, i});
                grid[0][i] = 1;
            }
        }
        int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()) {
            int[] p = q.poll();
            if(p[0] == r - 1) return true;
            for(int i = 0; i < dir.length; i++) {
                int x = p[0] + dir[i][0];
                int y = p[1] + dir[i][1];
                if(x < 0 || y < 0 || x == r || y == c || grid[x][y] == 1) continue;
                q.offer(new int[]{x, y});
                grid[x][y] = 1;
            }
        }
        return false;
    }
}