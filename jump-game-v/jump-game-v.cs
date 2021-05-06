public class Solution {
    private int[] cache;
    private int d;
    public int MaxJumps(int[] arr, int d) {
        cache =  new int[arr.Length];
        this.d = d;
        int max = 1;
        for(int i = 0; i < arr.Length; i++) {
            max = Math.Max(max, dfs(arr, i));
        }
        return max;
    }
    private int dfs(int[] arr, int index) {
        if(cache[index] > 0) {
            return cache[index];
        }
        int start = Math.Max(0, index - d);
        int end = Math.Min(arr.Length - 1, index + d);
        int max = 1;
        for(int i = index + 1; i <= end && arr[index] > arr[i]; i++) {
            max = Math.Max(max, dfs(arr, i) + 1);
        }
         for(int i = index - 1; i >= start && arr[index] > arr[i]; i--) {
            max = Math.Max(max, dfs(arr, i) + 1);
        }
        cache[index] = max;
        return max;
    }
}