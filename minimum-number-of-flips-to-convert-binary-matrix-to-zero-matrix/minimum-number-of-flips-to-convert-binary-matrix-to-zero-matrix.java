class Solution {
    private int[][] mat;
    private HashMap<String, Integer> map;
    public int minFlips(int[][] mat) {
        this.mat = mat;
        map = new HashMap<>();
        int min = dfs(new HashSet<>());
        return min == Integer.MAX_VALUE? -1 : min;
    }
    private int dfs(HashSet<String> set) {
        if(check()) return 0;
        String s = "";
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                s += String.valueOf(mat[i][j]);
            }
        }
        if(map.containsKey(s)) return map.get(s);
        if(set.contains(s)) return Integer.MAX_VALUE;
        set.add(s);
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                flip(i, j);
                int min = dfs(set);
                if(min != Integer.MAX_VALUE) res = Math.min(res, min + 1);
                flip(i, j);
            }
        }
        set.remove(s);
        map.put(s, res);
        return res;
    }
    private void flip(int i, int j) {
        int[][] dir = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        mat[i][j] ^= 1;
        for(int[] d : dir) {
            int x = i + d[0];
            int y = j + d[1];
            if(x >= 0 && y >= 0 && x < mat.length && y < mat[0].length) {
                mat[x][y] ^= 1;
            }
        }
    }
    private boolean check() {
        for(int i = 0; i < mat.length; i++) {
            for(int j = 0; j < mat[0].length; j++) {
                if(mat[i][j] == 1) return false;
            }
        }
        return true;
    }
}