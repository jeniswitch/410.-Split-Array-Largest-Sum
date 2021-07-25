class Solution {
    private int res;
    public int minimumTimeRequired(int[] jobs, int k) {
        res = Integer.MAX_VALUE;
        dfs(jobs, k, jobs.length - 1, new int[k]);
        return res;
    }
    private void dfs(int[] jobs, int k, int p, int[] sum) {
        if(p < 0) {
            res = Math.min(res, Arrays.stream(sum).max().getAsInt());
            return;
        }
        if(Arrays.stream(sum).max().getAsInt() > res) return;
        for(int i = 0; i < k; i++) {
            if(i > 0 && sum[i] == sum[i - 1]) continue;
            sum[i] += jobs[p];
            dfs(jobs, k, p - 1, sum);
            sum[i] -= jobs[p];
        }
    }
}