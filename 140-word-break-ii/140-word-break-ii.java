class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        return dfs(s, wordDict, new HashMap<>());
    }
    private List<String> dfs(String s, List<String> wordDict, Map<String, List<String>> map) {
        if(map.containsKey(s)) {
            return map.get(s);
        }
        List<String> res = new ArrayList<>();
        if(s.length() == 0) {
            res.add("");
            return res;
        }
        for(String w : wordDict) {
            if(s.startsWith(w)) {
                List<String> lst = dfs(s.substring(w.length()), wordDict, map);
                for(String str : lst) {
                    res.add(w + (str.length() == 0 ? "" : " ") + str);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}