class Solution {
    private int min = Integer.MAX_VALUE;
    private int size = 0;
    public int minimumIncompatibility(int[] nums, int k) {
        int n = nums.length;
        size = n / k;
        
        List<Set<Integer>> sets = new ArrayList<>();
        for(int i = 0; i < k; i++) {
            sets.add(new HashSet<>());
        }
        dfs(sets, nums, 0, 0);
        return min == Integer.MAX_VALUE ? -1 : min;
    }
    private void dfs(List<Set<Integer>> sets, int[] nums, int p, int acc) {
        if(p == nums.length) {
            min = Math.min(min, acc);
            return;
        }
        Set<Set<Integer>> visited = new HashSet<>();
        for(Set<Integer> set : sets) {
            if(set.size() == size || visited.contains(set) || set.contains(nums[p])) {
                continue;
            }
            int res = calculate(set, nums[p]);
            acc += res;
            if(acc < min) {
                set.add(nums[p]);
                dfs(sets, nums, p + 1, acc);
                set.remove(nums[p]);
            }
            acc -= res;
            visited.add(set);
        }
    }
    private int calculate(Set<Integer> set, int num) {
        if(set.size() == 0) return 0;
        if(set.size() == 1) return Math.abs(num - set.iterator().next());
        int minv = Integer.MAX_VALUE, maxv = 0;
        for(int n : set) {
            minv = Math.min(n, minv);
            maxv = Math.max(n, maxv);
        }
        if(num > maxv) return num - maxv;
        if(num < minv) return minv - num;
        return 0;
    }
}