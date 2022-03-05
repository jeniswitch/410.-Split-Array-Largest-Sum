class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new boolean[nums.length], res, new ArrayList<>());
        return res;
    }
    private void dfs(int[] nums, boolean[] visited, List<List<Integer>> res, List<Integer> lst) {
        if(lst.size() == nums.length) {
            res.add(new ArrayList<>(lst));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            lst.add(nums[i]);
            dfs(nums, visited, res, lst);
            visited[i] = false;
            lst.remove(lst.size() - 1);
        }
    }
}