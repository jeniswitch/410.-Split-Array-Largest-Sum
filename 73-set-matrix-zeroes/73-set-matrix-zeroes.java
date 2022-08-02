class Solution {
    public void setZeroes(int[][] matrix) {
        boolean row1Has0 = false;
        boolean col1Has0 = false;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if(i == 0 && !row1Has0) {
                        row1Has0 = true;
                    }
                    if(j == 0 && !col1Has0) {
                        col1Has0 = true;
                    }
                }
            }
        }
        for(int i = 1; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                zeroRow(matrix, i);
            }
        }
        for(int j = 1; j < matrix[0].length; j++) {
            if(matrix[0][j] == 0) {
                zeroCol(matrix, j);
            }
        }
        if(row1Has0) {
            zeroRow(matrix, 0);
        }
        if(col1Has0) {
            zeroCol(matrix, 0);
        }
    }
    private void zeroRow(int[][] matrix, int i) {
        for(int j = 0; j < matrix[0].length; j++) {
            matrix[i][j] = 0;
        }
    }
    private void zeroCol(int[][] matrix, int j) {
        for(int i = 0; i < matrix.length; i++) {
            matrix[i][j] = 0;
        }
    }
}