class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        dfs(n, 1, k, new ArrayList<Integer>());
        return res;
    }
    private void dfs(int n, int i, int k, List<Integer> temp) {
        if(k == 0) {
            res.add(new ArrayList<Integer>(temp));
            return;
        }
        for(int j = i; j <= n; j++) {
            temp.add(j);
            dfs(n, j + 1, k - 1, temp);
            temp.remove(temp.size() - 1);
        }
        
    }
}