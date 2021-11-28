class Solution {
    private long max;
    private int count;
    public int countHighestScoreNodes(int[] parents) {
        List<List<Integer>> lst = new ArrayList<>();
        max = 0l;
        count = 0;
        int n = parents.length;
        for(int i = 0; i < n; i++) {
            lst.add(new ArrayList<>());
        }
        for(int i = 1; i < n; i++) {
            lst.get(parents[i]).add(i);
        }
        dfs(lst, 0, n);
        return count;
    }
    private int dfs(List<List<Integer>> lst, int i, int n) {
        int total = 0;
        long prod = 1;
        for(int node : lst.get(i)) {
            int val = dfs(lst, node, n);
            prod *= val;
            total += val;
        }
        long rem = (long)(n - total - 1);
        if(rem > 0) {
            prod *= rem;
        }
        if(prod > max) {
            max = prod;
            count = 1;
        }
        else if(prod == max){
            count++;
        }
        return total + 1;
    }

}