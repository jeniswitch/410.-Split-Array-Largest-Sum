class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>());
        return res;
    }
    private void dfs(int[] candidates, int target, int idx, List<Integer> lst) {
        if(target < 0) return;
        if(target == 0) {
            res.add(new ArrayList<>(lst));
            return;
        }
        for(int i = idx; i < candidates.length; i++) {
            if(i > idx && candidates[i] == candidates[i - 1]) continue;
            lst.add(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1, lst);
            lst.remove(lst.size() - 1);
        }
    }
}