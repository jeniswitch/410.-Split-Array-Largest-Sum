class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        dfs(candidates, target, 0, new ArrayList<>(), 0);
        return res;
    }
    private void dfs(int[] candidates, int target, int pos, List<Integer> lst, int sum) {
        if(candidates[pos] > target || sum > target) return;
        if(sum == target) {
            res.add(new ArrayList<>(lst));
            return;
        }
        for(int i = pos; i < candidates.length; i++) {
            lst.add(candidates[i]);
            dfs(candidates, target, i, lst, candidates[i] + sum);
            lst.remove(lst.size() - 1);
        }
    }
}