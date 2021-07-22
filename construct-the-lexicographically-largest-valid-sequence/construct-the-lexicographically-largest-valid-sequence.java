class Solution {
    public int[] constructDistancedSequence(int n) {
        int[] res = new int[2 * n - 1];
        boolean[] visited = new boolean[n + 1];
        dfs(res, 0, visited, n);
        return res;
    }
    private boolean dfs(int[] res, int p, boolean[] visited, int n) {
        if(p == res.length) {
            return true;
        }
        if(res[p] > 0) {
            return dfs(res, p + 1, visited, n);
        }
        for(int i = n; i > 0; i--) {
            if(visited[i]) continue;
            res[p] = i;
            visited[i] = true;
            if(i == 1) {
                if(dfs(res, p + 1, visited, n)) {
                    return true;
                }
            }
            if(i >= 2) {
                if(p + i < res.length && res[p + i] == 0) {
                    res[p + i] = i;
                    if(dfs(res, p + 1, visited, n)) return true;
                    res[p + i] = 0;
                }
            }
            res[p] = 0;
            visited[i] = false;

        }
        return false;
    }
}