class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int m = board.size();
        int[][] sum = new int[m][m];
        int[][] count = new int[m][m];
        count[m - 1][m - 1] = 1;
        long MOD = (long)1e9 + 7;
        int[][] dir = new int[][]{{0, -1}, {-1, 0}, {-1, -1}};
        for(int i = m - 1; i >= 0; i--) {
            for(int j = m - 1; j >= 0; j--) {
                if(count[i][j] == 0) continue;
                char c = board.get(i).charAt(j);
                if(c == 'E') continue;
                for(int[] d : dir) {
                    int newi = i + d[0];
                    int newj = j + d[1];
                    if(newi >= 0 && newj >= 0 && board.get(i).charAt(j) != 'X') {
                        int temp = sum[i][j];
                        if(board.get(newi).charAt(newj) != 'E') {
                            temp += board.get(newi).charAt(newj) - '0';
                        }
                        if(temp > sum[newi][newj]) {
                            sum[newi][newj] = temp;
                            count[newi][newj] = count[i][j];
                        }
                        else if(temp == sum[newi][newj]) {
                            count[newi][newj] = (int)((count[newi][newj] + count[i][j]) % MOD);
                        }
                    }
                }
            }
        }
        return new int[]{sum[0][0], count[0][0]};
    }
}