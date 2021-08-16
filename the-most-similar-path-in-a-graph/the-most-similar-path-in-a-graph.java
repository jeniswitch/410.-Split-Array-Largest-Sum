class Solution {
    private List<List<Integer>> adjMatrix;
    private int[][] visited, nextChoiceForMin;
    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
        adjMatrix = new ArrayList<List<Integer>>();
        visited = new int[names.length][targetPath.length];
        nextChoiceForMin = new int[names.length][targetPath.length];
        
        for(int[] x : visited) {
            Arrays.fill(x, -1);
        }
        
        //build matrix
        for(int i = 0; i < n; i++) {
            adjMatrix.add(new ArrayList<Integer>());
        }
        for(int[] road : roads) {
            adjMatrix.get(road[0]).add(road[1]);
            adjMatrix.get(road[1]).add(road[0]);
        }
        
        //from each node, calculate min and record the city
        int min = Integer.MAX_VALUE;
        int start = 0;
        for(int i = 0; i < names.length; i++) {
            int res = dfs(i, 0, names, targetPath);
            if(res < min) {
                min = res;
                start = i;
            }
        }
        
        //build the answer based on what is the best next choice
        List<Integer> res = new ArrayList<Integer>();
        while(res.size() < targetPath.length) {
            res.add(start);
            start = nextChoiceForMin[start][res.size() - 1];
        }
        return res;
    }
    
    private int dfs(int namesIdx, int crrPathIdx, String[] names, String[] targetPath) {
        if(visited[namesIdx][crrPathIdx] != -1) return visited[namesIdx][crrPathIdx];
        int editDist = names[namesIdx].equals(targetPath[crrPathIdx]) ? 0 : 1;
        if(crrPathIdx == targetPath.length - 1) return editDist;
        
        int min = Integer.MAX_VALUE;
        for(int neighbor : adjMatrix.get(namesIdx)) {
            int cost = dfs(neighbor, crrPathIdx + 1, names, targetPath);
            if(cost < min) {
                min = cost;
                nextChoiceForMin[namesIdx][crrPathIdx] = neighbor;
            }
        }
        editDist += min;
        visited[namesIdx][crrPathIdx] = editDist;
        return editDist;
    }
}