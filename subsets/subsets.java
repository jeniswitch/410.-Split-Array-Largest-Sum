class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
    private void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, int pos) {
        if(pos == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        dfs(res, temp, nums, pos + 1);
        temp.add(nums[pos]);
        dfs(res, temp, nums, pos + 1);
        temp.remove(temp.size() - 1);
    }
}