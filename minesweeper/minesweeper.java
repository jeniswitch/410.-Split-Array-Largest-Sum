class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        int i = click[0];
        int j = click[1];
        if(board[i][j] == 'M') {
            board[i][j] = 'X';
        }
        else {
            dfs(board, i, j);
        }
        return board;
    }
    private int[][] dir = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}, {-1, -1}, {1, 1}, {-1, 1}, {1, -1}};
    private void dfs(char[][] board, int i, int j) {
        if(i < 0 || j < 0 || i == board.length || j == board[0].length ||
            board[i][j] != 'E')           
                return;
        int mines = ajsMine(board, i, j);
        if(mines > 0) {
            board[i][j] = (char)('0' + mines);
        }
        else {
            board[i][j] = 'B';
           for(int[] d : dir) {
                int newi = i + d[0];
                int newj = j + d[1];
                dfs(board, newi, newj);
            }
        }
        
    }
    private int ajsMine(char[][] board, int i, int j) {
        int count = 0;
        for(int[] d : dir) {
            int newi = i + d[0];
            int newj = j + d[1];
            if(newi >= 0 && newj >= 0 && newi < board.length && newj < board[0].length && board[newi][newj] == 'M') {
                count++;
            }
        }
        return count;
    }
}