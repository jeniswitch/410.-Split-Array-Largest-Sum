class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        dfs(candidates, 0, target, new ArrayList<>(), 0);
        return res;
    }
    private void dfs(int[] candidates, int idx, int target, List<Integer> lst, int sum) {
        if(sum == target) {
            res. add(new ArrayList<>(lst));
            return;
        }
        if(sum > target) return;
        for(int i = idx; i < candidates.length; i++) {
            if(candidates[i] > target) return;
            lst.add(candidates[i]);
            dfs(candidates, i, target, lst, sum + candidates[i]);
            lst.remove(lst.size() - 1);
        }
    }
}