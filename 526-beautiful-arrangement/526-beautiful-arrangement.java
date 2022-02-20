class Solution {
    public int countArrangement(int n) {
        if(n == 1) return 1;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = i + 1;
        }
        int res = 0;
        return dfs(arr, 0,  new HashSet<>());
    }
    private int dfs(int[] arr, int pos, HashSet<Integer> visited) {
        if(visited.size() == arr.length) return 1;
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(visited.contains(i) || !isValid(pos, arr[i])) continue;
            visited.add(i);
            count += dfs(arr, pos + 1,  visited);
            visited.remove(i);
        }
        return count;
    }
    private boolean isValid(int i, int num) {
        return (i + 1) % num == 0 || num % (i + 1) == 0;
    }
}