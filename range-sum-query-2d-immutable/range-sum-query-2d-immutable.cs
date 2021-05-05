public class NumMatrix {
    private int[][] dp;
    public NumMatrix(int[][] matrix) {
        dp = new int[matrix.Length][];
        for(int i = 0; i < matrix.Length; i++) {
            dp[i] = new int[matrix[0].Length + 1];
            for(int j = 1; j < matrix[0].Length + 1; j++) {
                dp[i][j] = dp[i][j - 1] +  matrix[i][j - 1];
            }
        }
    }
    
    public int SumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int j = row1; j <= row2; j++) {
            sum += dp[j][col2 + 1] - dp[j][col1];
        }
        return sum;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.SumRegion(row1,col1,row2,col2);
 */