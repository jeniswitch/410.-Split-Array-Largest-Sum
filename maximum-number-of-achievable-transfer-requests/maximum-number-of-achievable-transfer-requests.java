class Solution {
    private int max;
    public int maximumRequests(int n, int[][] requests) {
        max = 0;
        dfs(requests, 0, new int[n], 0);
        return max;
    }
    private void dfs(int[][] requests, int i, int[] count, int num) {
        if(i == requests.length) {
            for(int c : count) {
                if(c != 0) {
                    return;
                }
            }
            max = Math.max(max, num);
            return;
        }
        count[requests[i][0]]++;
        count[requests[i][1]]--;
        dfs(requests, i + 1, count, num + 1);
        count[requests[i][0]]--;
        count[requests[i][1]]++;
        
        dfs(requests, i + 1, count, num);
    }
}