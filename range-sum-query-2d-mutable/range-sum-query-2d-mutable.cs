public class NumMatrix {
    public class BIT {
        public int[][] bit;
        public BIT(int[][] matrix) {
            int m = matrix.Length + 1;
            int n = matrix[0].Length + 1;
            bit = new int[m][];
            for(int i = 0; i < m; i++) {
                bit[i] = new int[n];
            }
            BuildTree(matrix);
        }
        private void BuildTree(int[][] matrix) {
            for(int i = 1; i < bit.Length; i++) {
                for(int j = 1; j < bit[0].Length; j++) {
                    Update(i, j, matrix[i - 1][j - 1]);
                }
            }
        }
        public void Update(int i, int j, int val) {
            //int indexi = i;
            //int indexj = j;
            /*while(indexi < bit.Length) {
                while(indexj < bit[0].Length) {
                    bit[indexi][indexj] += val;
                    indexj += indexj & (-indexj);
                }
                indexi += indexi & (-indexi);
            }*/
            for(int indexi = i; indexi < bit.Length; indexi += indexi & (-indexi)) {
                for(int indexj = j; indexj < bit[0].Length; indexj += indexj & (-indexj)) {
                    bit[indexi][indexj] += val;
                }
            }
        }
        public int Get(int i, int j) {
            //int indexi = i;
            //int indexj = j;
            int sum = 0;
            /*while(indexi > 0) {
                while(indexj > 0) {
                    sum += bit[indexi][indexj];
                    indexj -= indexj & (-indexj);
                }
                indexi -= indexi & (-indexi);
            }*/
            for(int indexi = i; indexi > 0; indexi -= indexi & (-indexi)) {
                for(int indexj = j; indexj > 0; indexj -= indexj & (-indexj)) {
                    sum += bit[indexi][indexj];
                }
            }
            return sum;
        }
    }
    private BIT tree;
    private int[][] localMatrix;
    public NumMatrix(int[][] matrix) {
        tree = new BIT(matrix);
        localMatrix = matrix;
    }
    
    public void Update(int row, int col, int val) {
        int diff = val - SumRegion(row, col, row, col);
        tree.Update(row + 1, col + 1, diff);
    }
    
    public int SumRegion(int row1, int col1, int row2, int col2) {
        return tree.Get(row2 + 1, col2 + 1) - tree.Get(row1, col2 + 1) - tree.Get(row2 + 1, col1) + tree.Get(row1, col1);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * obj.Update(row,col,val);
 * int param_2 = obj.SumRegion(row1,col1,row2,col2);
 */