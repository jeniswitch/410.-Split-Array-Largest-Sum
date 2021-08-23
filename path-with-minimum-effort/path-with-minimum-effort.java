class Solution {
    public int minimumEffortPath(int[][] heights) {
        final int[][] dir = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int m = heights.length, n = heights[0].length;
        int[][] d = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(d[i], Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[2] - b[2]);
        pq.offer(new int[]{0, 0, 0});
        while(!pq.isEmpty()) {
            int[] crr = pq.poll();
            int r = crr[0], c = crr[1], dis = crr[2];
            if(dis > d[r][c]) continue;
            if(r == m - 1 && c == n - 1) return dis;
            for(int i = 0; i < dir.length; i++) {
                int newR = r + dir[i][0];
                int newC = c + dir[i][1];
                if(newR >= 0 && newR < m && newC >= 0 && newC < n) {
                    int max = Math.max(dis, Math.abs(heights[r][c] - heights[newR][newC]));
                    if(d[newR][newC] > max) {
                        d[newR][newC] = max;
                        pq.offer(new int[]{newR, newC, max});
                    }
                }
            }
        }
        return 0;
    }
}