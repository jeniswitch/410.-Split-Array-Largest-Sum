class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        HashSet<Integer> left = new HashSet<>();
        HashSet<Integer> right = new HashSet<>();
        dfs(nums, 0, nums.length / 2, 0, left);
        dfs(nums, nums.length / 2, nums.length, 0, right);
        TreeSet<Integer> set = new TreeSet<>(right);
        int res = Integer.MAX_VALUE;
        for(int l : left) {
            int r = goal - l;
            if(set.contains(r)) {
                return 0;
            }
            Integer f = set.floor(r);
            Integer c = set.ceiling(r);
            
            if(f != null) {
                res = Math.min(res, Math.abs(l + f - goal));
            }
            if(c != null) {
                res = Math.min(res, Math.abs(l + c - goal));
            }
        }
        return res;
    }
    private void dfs(int[] nums, int start, int end, int sum, HashSet<Integer> set) {
        if(start == end) {
            set.add(sum);
            return;
        }
        dfs(nums, start + 1, end, sum + nums[start], set);
        dfs(nums, start + 1, end, sum, set);
    }
}