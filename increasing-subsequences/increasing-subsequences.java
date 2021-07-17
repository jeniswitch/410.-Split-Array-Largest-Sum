class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(res, nums, 0, new ArrayList<Integer>());
        return res;
    }
    private void dfs(List<List<Integer>> res, int[] nums, int p, List<Integer> temp) {
        if(temp.size() > 1) {
            res.add(new ArrayList<>(temp));
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = p; i < nums.length; i++) {
            if(set.contains(nums[i])) continue;
            if(temp.size() == 0 || temp.size() > 0 && nums[i] >= temp.get(temp.size() - 1)) {
                set.add(nums[i]);
                temp.add(nums[i]);
                dfs(res, nums, i + 1, temp);
                temp.remove(temp.size() - 1);
            }
        }
    }
}