class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length, n = mat[0].length;
        if(m == r && n == c || m * n != (r * c)) return mat;
        int i = 0, j = 0;
        int[][] res = new int[r][c];
        for(int oi = 0; oi < m; oi++) {
            for(int oj = 0; oj < n; oj++) {
                if(j == c) {
                    i++;
                    j = 0;
                }
                res[i][j++] = mat[oi][oj];
            }
        }
        return res;
    }
}