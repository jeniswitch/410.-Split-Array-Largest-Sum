class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        dfs(nums, 0, new ArrayList<Integer>(), res);
        return res;
    }
    private void dfs(int[] nums, int p, List<Integer> temp, List<List<Integer>> res) {
        res.add(new ArrayList<>(temp));
        for(int i = p; i < nums.length; i++) {
            if(i != p && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]);
            dfs(nums, i + 1, temp, res);
            temp.remove(temp.size() - 1);
        }
    }
}