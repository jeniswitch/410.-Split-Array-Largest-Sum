class Solution {
    public int countArrangement(int n) {
        if(n == 1) return 1;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        int res = 0;
        return dfs(arr, 1,  new boolean[n]);
    }
    private int dfs(int[] arr, int pos, boolean[] visited) {
        if(pos == arr.length + 1) return 1;
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(visited[i] || !isValid(pos, arr[i])) continue;
            visited[i] = true;
            count += dfs(arr, pos + 1,  visited);
            visited[i] = false;
        }
        return count;
    }
    private boolean isValid(int i, int num) {
        return i % num == 0 || num % i == 0;
    }
}