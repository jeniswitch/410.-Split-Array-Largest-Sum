class Solution {
    private List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>(), 0);
        return res;
    }
    private void dfs(int[] candidates, int target, int pos, List<Integer> lst, int sum) {
        if(sum == target) {
            res.add(new ArrayList<>(lst));
            return;
        }
        if(pos == candidates.length || sum > target || candidates[pos] > target) return;
        for(int i = pos; i < candidates.length; i++) {
            int csum = candidates[i] + sum;
            if(csum > target) break;
            if(i > pos && candidates[i] == candidates[i - 1]) {
                continue;
            }
            lst.add(candidates[i]);
            dfs(candidates, target, i + 1, lst, csum);
            lst.remove(lst.size() - 1);
        }
    }
}