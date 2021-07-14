class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(res, new ArrayList<Integer>(), nums, 0, true);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, int pos, boolean choose) {
        if(pos == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        dfs(res, temp, nums, pos + 1, false);
        if(pos >= 1 && nums[pos] == nums[pos - 1] && !choose) return;
        temp.add(nums[pos]);
        dfs(res, temp, nums, pos + 1, true);
        temp.remove(temp.size() - 1);
    }
}