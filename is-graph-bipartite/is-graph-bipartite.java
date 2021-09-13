class Solution {
    private int[] color;
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        for(int i = 0; i < n; i++) {
            if(color[i] == 0 && !dfs(graph, i, 1)) return false;
        }
        return true;
    }
    private boolean dfs(int[][] graph, int node, int c) {
        color[node] = c;
        for(int i : graph[node]) {
            if(color[i] == -c) continue;
            if(color[i] == c || !dfs(graph, i, -c)) return false;
        }
        return true;
    }
}