class Solution {
    private int[] p;
    public List<Boolean> areConnected(int n, int threshold, int[][] queries) {
        p = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            p[i] = i;
        }
        for(int i = threshold + 1; i <= n; i++) {
            for(int j = 2 * i; j <= n; j += i) {
                union(j, i);
            }
        }
        List<Boolean> res = new ArrayList<>();
        for(int[] q : queries) {
            res.add(find(q[0]) == find(q[1]));
        }
        return res;
    }
    private int find(int x) {
        if(x != p[x]) p[x] = find(p[x]);
        return p[x];
    }
    private void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if(px != py) {
            p[px] = p[py];
        }
    }
}
