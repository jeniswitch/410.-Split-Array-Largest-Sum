class Solution {
    public int minimumCost(int n, int[][] connections) {
        Arrays.sort(connections, (a, b) -> a[2] - b[2]);
        int[] p = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            p[i] = i;
        }
        int count = 0, res = 0;
        for(int i = 0; i < connections.length; i++) {
            int x = connections[i][0];
            int y = connections[i][1];
            int cost = connections[i][2];
            int px = find(x, p);
            int py = find(y, p);
            if(px != py) {
                p[px] = py;
                count++;
                res += cost;
            }
        }
        return count == n - 1 ? res : -1;
    }
    private int find(int x, int[] p) {
        if(x != p[x]) p[x] = find(p[x], p);
        return p[x];
    }
}