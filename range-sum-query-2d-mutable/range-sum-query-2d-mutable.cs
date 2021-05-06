public class NumMatrix {
    private int[][] bit;
    public NumMatrix(int[][] matrix) {
        int m = matrix.Length + 1;
        int n = matrix[0].Length + 1;
        bit = new int[m][];
        for(int i = 0; i < m; i++) {
            bit[i] = new int[n];
        }
        //build tree
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                UpdateBIT(i, j, matrix[i - 1][j - 1]);
            }
        }
    }
    private void UpdateBIT(int row, int col, int val) {
        for(int i = row; i < bit.Length; i += i & -i) {
            for(int j = col; j < bit[0].Length; j += j & -j) {
                bit[i][j] += val;
            }
        }
    }
    private int GetBIT(int row, int col) {
        int sum = 0;
        for(int i = row; i > 0; i -= i & -i) {
            for(int j = col; j > 0; j -= j & -j) {
                sum += bit[i][j];
            }
        }
        return sum;
    }
    public void Update(int row, int col, int val) {
        UpdateBIT(row + 1, col + 1, val - SumRegion(row, col, row, col));
    }
    
    public int SumRegion(int row1, int col1, int row2, int col2) {
        return GetBIT(row2 + 1, col2 + 1) - GetBIT(row1, col2 + 1) - GetBIT(row2 + 1, col1) + GetBIT(row1, col1);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.Update(row,col,val);
 * int param_2 = obj.SumRegion(row1,col1,row2,col2);
 */