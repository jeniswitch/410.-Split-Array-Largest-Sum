class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0;
        int[][] dir = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1 ,0}};
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
                else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if(fresh == 0) return 0;
        int count = -1;
        while(!q.isEmpty()) {
            int size = q.size();
            count++;
            for(int i = 0; i < size; i++) {
                int[] idx = q.poll();
                for(int[] d : dir) {
                    int newX = idx[0] + d[0];
                    int newY = idx[1] + d[1];
                    if(newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length && grid[newX][newY] == 1) {
                        grid[newX][newY] = 2;
                        q.offer(new int[]{newX, newY});
                        fresh--;
                    }
                }
            }
        }
        return fresh == 0 ? count : -1;
    }
}