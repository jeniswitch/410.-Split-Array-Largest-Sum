class Solution {
    private List<List<String>> res;
    private boolean[] col, dg, rdg;
    private char[][] g;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<List<String>>();
        col = new boolean[n];
        dg = new boolean[2 * n];
        rdg = new boolean[2 * n];
        g = new char[n][n];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                g[i][j] = '.';
            }
        }
        dfs(0, n);
        return res;
    }
    private void dfs(int r, int n) {
        if(r == n) {
            List<String> lst = new ArrayList<String>();
            for(int i = 0; i < n; i++) {
                String s = "";
                for(int j = 0; j < n; j++) {
                    s += g[i][j];
                }
                lst.add(s);
            }
            res.add(lst);
        }
        for(int c = 0; c < n; c++) {
            if(!col[c] && !dg[c - r + n] && !rdg[c + r]) {
                col[c] = dg[c - r + n] = rdg[c + r] = true;
                g[r][c] = 'Q';
                dfs(r + 1, n);
                col[c] = dg[c - r + n] = rdg[c + r] = false;
                g[r][c] = '.';
            }
        }
    }
}