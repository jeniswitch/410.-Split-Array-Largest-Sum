class Solution {
    private List<String> res;
    public List<String> letterCasePermutation(String s) {
        res = new ArrayList<>();
        dfs(0, s.toCharArray(), new StringBuilder());
        return res;
    }
    private void dfs(int i, char[] arr, StringBuilder sb) {
        if(i == arr.length) {
            res.add(sb.toString());
            return;
        }
        sb.append(arr[i]);
        dfs(i + 1, arr, sb);
        sb.setLength(sb.length() - 1);
        if(arr[i] >= 'a' && arr[i] <= 'z') {
            sb.append(Character.toUpperCase(arr[i]));
            dfs(i + 1, arr, sb);
            sb.setLength(sb.length() - 1);
        }
        else if(arr[i] >= 'A' && arr[i] <= 'Z'){
            sb.append(Character.toLowerCase(arr[i]));
            dfs(i + 1, arr, sb);
            sb.setLength(sb.length() - 1);
        }
        
    }
}