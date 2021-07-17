class Solution {
    private HashMap<Integer, Integer> cntMap;
    private HashMap<Integer, HashSet<Integer>> sqMap;
    private int cnt = 0;
    public int numSquarefulPerms(int[] nums) {
        cntMap = new HashMap<>();
        sqMap = new HashMap<>();
        for(int num : nums) {
            cntMap.put(num, cntMap.getOrDefault(num, 0) + 1);
            if(!sqMap.containsKey(num)) {
                sqMap.put(num, new HashSet<Integer>());
            }
        }
        for(int num1 : cntMap.keySet()) {
            for(int num2 : cntMap.keySet()) {
                double c = Math.sqrt(num1 + num2);
                if(c == Math.floor(c)) {
                    sqMap.get(num1).add(num2);
                    sqMap.get(num2).add(num1);
                }
            }
        }
        for(int num : cntMap.keySet()) {
            dfs(num, nums.length - 1);
        }
        return cnt;
    }
    private void dfs(int num, int left) {
        if(left == 0) {
            cnt++;
            return;
        }
        cntMap.put(num, cntMap.get(num) - 1);
        for(int next : sqMap.get(num)) {
            if(cntMap.get(next) > 0) {
                dfs(next, left - 1);
            }
        }
        cntMap.put(num, cntMap.get(num) + 1);
    }
}