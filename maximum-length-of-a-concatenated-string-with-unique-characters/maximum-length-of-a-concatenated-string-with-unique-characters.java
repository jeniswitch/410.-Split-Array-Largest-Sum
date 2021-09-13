class Solution {
    private int max;
    public int maxLength(List<String> arr) {
        max = 0;
        dfs(arr, 0, "");
        return max;
    }
    private void dfs(List<String> arr, int i, String str) {
        if(isUnique(str)) max = Math.max(max, str.length());
        if(i == arr.size() || !isUnique(str)) return;
        for(int j = i; j < arr.size(); j++) {
            dfs(arr, j + 1, str + arr.get(j));
        }
    }
    private boolean isUnique(String str) {
        int[] b = new int[26];
        for(char c : str.toCharArray()) {
            b[c - 'a']++;
        }
        for(char c : str.toCharArray()) {
            if(b[c -'a'] > 1) return false;
        }
        return true;
    }
}