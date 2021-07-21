/**
 * // This is the GridMaster's API interface.
 * // You should not implement it, or speculate about its implementation
 * class GridMaster {
 *     boolean canMove(char direction);
 *     void move(char direction);
 *     boolean isTarget();
 * }
 */

class Solution {
    private static final int[][] DIRECTION = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final char[] FORWARD = {'U', 'D', 'L', 'R'};
    private static final char[] BACKWARD = {'D', 'U', 'R', 'L'};
    
    private static final int UNVISITED = 0;
    private static final int PATH = 1;
    private static final int TARGET = 2;
    private static final int BLOCKED = -1;
    public int findShortestPath(GridMaster master) {
        int m = 500;
        int[][] matrix = new int[2 * m][2 * m];
        dfs(matrix, m, m, master);
        
        //bfs
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{m, m});
        matrix[m][m] = BLOCKED;
        int dis = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size > 0) {
                int[] pos = q.poll();
                for(int i = 0; i < 4; i++) {
                    int rr = pos[0] + DIRECTION[i][0];
                    int cc = pos[1] + DIRECTION[i][1];
                    if(matrix[rr][cc] == TARGET) return dis + 1;
                    if(matrix[rr][cc] == BLOCKED) continue;
                    q.offer(new int[]{rr, cc});
                    matrix[rr][cc] = BLOCKED;
                }
                size--;
            }
            dis++;
        }
        return -1;
    }
    private void dfs(int[][] matrix, int r, int c, GridMaster master) {
        if(matrix[r][c] != UNVISITED) {
            return;
        }
        matrix[r][c] = master.isTarget() ? TARGET : PATH;
        for(int i = 0; i < 4; i++) {
            char forward = FORWARD[i];
            char backward = BACKWARD[i];
            int rr = r + DIRECTION[i][0];
            int cc = c + DIRECTION[i][1];
            
            if(!master.canMove(forward)) {
                matrix[rr][cc] = BLOCKED;
            }
            else {
                master.move(forward);
                dfs(matrix, rr, cc, master);
                master.move(backward);
            }
        }
    }
    
}