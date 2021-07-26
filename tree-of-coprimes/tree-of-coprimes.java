class Solution {
    private static final int N = 51;
    private static final int MAX = Integer.MAX_VALUE;
    private boolean[][] prime;
    private List<Integer> gragh[];
    private HashMap<Integer, int[]> ancester;
    public int[] getCoprimes(int[] nums, int[][] edges) {
        prime = new boolean[N][N];
        gragh = new ArrayList[nums.length];
        ancester = new HashMap<>();
        for(int a = 1; a < N; a++) {
            for(int b = 1; b < N; b++) {
                if(gcd(a, b) == 1) {
                    prime[a][b] = prime[b][a] = true;
                }
            }
        }
        for(int i = 0; i < nums.length; i++) {
            gragh[i] = new ArrayList<>();
        }
        for(int[] e : edges) {
            gragh[e[0]].add(e[1]);
            gragh[e[1]].add(e[0]);
        }
        int[] res = new int[nums.length];
        dfs(0, 0, -1, res, nums);
        return res;
    }
    private int gcd(int x, int y) {
        if(y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }
    private void dfs(int idx, int depth, int parrent, int[] res, int[] nums) {
        int d = MAX, index = -1;
        for(int i = 1; i < N; i++) {
            if(prime[i][nums[idx]] && ancester.containsKey(i)) {
                if(d > depth - ancester.get(i)[0]) {
                    d = depth - ancester.get(i)[0];
                    index = ancester.get(i)[1];
                }
            }
        }
        res[idx] = index;
        
        int[] oldEntry = ancester.containsKey(nums[idx])? ancester.get(nums[idx]) : new int[]{-1, -1};
        ancester.put(nums[idx], new int[]{depth, idx});
        for(int children : gragh[idx]) {
            if(children == parrent) {
                continue;
            }
            dfs(children, depth + 1, idx, res, nums);
        }
        if(oldEntry[0] != -1) {
            ancester.put(nums[idx], oldEntry);
        }
        else {
            ancester.remove(nums[idx]);
        }
    }
}