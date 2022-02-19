class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        res = new ArrayList<>();
        for(int i = 0; i < candidates.length; i++) {
            if(candidates[i] > target) return res;
            if(i > 0 && candidates[i] == candidates[i - 1]) continue;
            List<Integer> lst = new ArrayList<>();
            lst.add(candidates[i]);
            dfs(candidates, target, i + 1, lst, candidates[i]);
        }
        return res;
    }
    private void dfs(int[] candidates, int target, int idx, List<Integer> lst, int sum) {
        if(sum > target) return;
        if(sum == target) {
            res.add(new ArrayList<>(lst));
            return;
        }
        int last = 0;
        for(int i = idx; i < candidates.length; i++) {
            if(candidates[i] > target || sum + candidates[i] > target) return;  
            if(last > 0 && candidates[i] == last) continue;
            lst.add(candidates[i]);
            dfs(candidates, target, i + 1, lst, sum + candidates[i]);
            lst.remove(lst.size() - 1);
            last = candidates[i];
        }
    }
}