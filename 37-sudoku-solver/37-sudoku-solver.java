class Solution {
    public void solveSudoku(char[][] board) {
        dfs(board);
    }
    private boolean dfs(char[][] board) {        
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    for(char c = '1'; c <= '9'; c++) {
                        if(check(board, i, j, c)) {
                            board[i][j] = c;
                            if(dfs(board)) return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    private boolean check(char[][] board, int r, int co, int c) {
        int iStart = r / 3 + 2 * (r / 3);
        int jStart = co / 3 + 2 * (co / 3);
        for(int i = 0; i < 9; i++) {
            if(board[r][i] == c || board[i][co] == c) return false;
        }
        for(int i = iStart; i <= iStart + 2; i++) {
            for(int j = jStart; j <= jStart + 2; j++) {
                if(board[i][j] == c) return false;
            }
        }
        return true;
    }
    
}