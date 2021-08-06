class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(nums, 0, new ArrayList<Integer>(), res, new boolean[nums.length]);
        return res;
    }
    private void dfs(int[] nums, int p, List<Integer> temp, List<List<Integer>> res, boolean[] visited) {
        if(p == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                temp.add(nums[i]);
                dfs(nums, p + 1, temp, res, visited);
                visited[i] = false;
                temp.remove(temp.size() - 1);
            }
        }
    }
}