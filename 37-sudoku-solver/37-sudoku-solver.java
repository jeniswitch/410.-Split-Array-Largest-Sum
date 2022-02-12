class Solution {
    public void solveSudoku(char[][] board) {
        int n = 9;
        HashMap<Integer, HashSet<Character>> rows = new HashMap<>();;
        HashMap<Integer, HashSet<Character>> cols = new HashMap<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                char c = board[i][j];
                if(c == '.') {
                    continue;
                }
                rows.putIfAbsent(i, new HashSet<>());
                rows.get(i).add(c);
                cols.putIfAbsent(j, new HashSet<>());
                cols.get(j).add(c);                
            }
        }
        dfs(board, rows, cols);
    }
    private boolean dfs(char[][] board, HashMap<Integer, HashSet<Character>> rows, 
                     HashMap<Integer, HashSet<Character>> cols) {        
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(board[i][j] == '.') {
                    int count = 0;
                    for(char c = '1'; c <= '9'; c++) {
                        if(rows.get(i).contains(c) || cols.get(j).contains(c) || checkSquare(c, board, i, j)) {
                            count++;
                            continue;
                        } 
                        board[i][j] = c;
                        rows.get(i).add(c);
                        cols.get(j).add(c);
                        if(!dfs(board, rows, cols)) {
                            board[i][j] = '.';
                            rows.get(i).remove(c);
                            cols.get(j).remove(c);
                            count++;
                        }
                        else {
                            break;
                        }
                    }
                    if(count == 9) return false;
                }
            }
        }
        return true;
    }
    private boolean checkSquare(char c, char[][] board, int i, int j) {
        int iStart = getStart(i), iEnd = iStart + 2;
        int jStart = getStart(j), jEnd = jStart + 2;
        for(int k = iStart; k <= iEnd; k++) {
            for(int f = jStart; f <= jEnd; f++) {
                if(board[k][f] == c) return true;
            }
        }
        return false;
    }
    private int getStart(int i) {
        if(i < 3) return 0;
        else if(i < 6) return 3;
        else return 6;
    }
    
}