class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return dfs(nums, 0);
    }
    private List<List<Integer>> dfs(int[] nums, int pos) {
        List<List<Integer>> res = new ArrayList<>();
        if(pos == nums.length) {
            res.add(new ArrayList<>());
            return res;
        }
        List<List<Integer>>  temp = dfs(nums, pos + 1);
        for(List<Integer> t : temp) {
            res.add(t);
            List<Integer> newLst = new ArrayList<>(t);
            newLst.add(nums[pos]);
            res.add(newLst);
        }  
        return res;
    }
}