class Solution {
    public int maxUniqueSplit(String s) {
        return dfs(new HashSet<String>(), 0, s);
    }
    private int dfs(HashSet<String> hs, int idx, String s) {
        if(idx == s.length()) {
            return 0;
        }
        int res = -1;
        for(int i = idx + 1; i <= s.length(); i++) {
            String str = s.substring(idx, i);
            if(!hs.add(str)) continue;
            res = Math.max(res, 1 + dfs(hs, i, s));
            hs.remove(str);
        }
        return res;
    }
}