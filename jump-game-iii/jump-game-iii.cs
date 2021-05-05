public class Solution {
    public bool CanReach(int[] arr, int start) {
        bool[] visited = new bool[arr.Length];
        return dfs(arr, start, visited);
    }
    private bool dfs(int[] arr, int index, bool[] visited) {
        if(index >= arr.Length || index < 0 || visited[index]) {
            return false;
        }
        if(arr[index] == 0) {
            return true;
        }
        int right = index + arr[index];
        int left = index - arr[index];
        visited[index] = true;
        return dfs(arr, right, visited) || dfs(arr, left, visited);
    }
}