class Solution {
    private HashMap<Integer, List<Integer>> map;
    private Random rand;
    public Solution(int[] nums) {
        map = new HashMap<>();
        rand = new Random();
        for(int i = 0; i < nums.length; i++) {
            int n = nums[i];
            map.putIfAbsent(n, new ArrayList<Integer>());
            map.get(n).add(i);
        }
    }
    
    public int pick(int target) {
        List<Integer> lst = map.get(target);
        int idx = rand.nextInt(lst.size());
        return lst.get(idx);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */