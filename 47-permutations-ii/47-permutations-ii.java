class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, new ArrayList<>(), new boolean[nums.length], res);
        return res;
    }
    private void dfs(int[] nums, List<Integer> lst, boolean[] visited, List<List<Integer>> res) {
        if(lst.size() == nums.length) {
            res.add(new ArrayList<>(lst));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(visited[i] || (i > 0 && nums[i] == nums[i - 1] && visited[i - 1])) continue;
            visited[i] = true;
            lst.add(nums[i]);
            dfs(nums, lst, visited, res);
            visited[i] = false;
            lst.remove(lst.size() - 1);
        }
    }
}