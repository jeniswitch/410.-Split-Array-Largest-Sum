public class Solution {
    public int LongestStrChain(string[] words) {
        var map = new Dictionary<string, int>();
        var wset = new HashSet<string>();
        int max = 0;
        foreach(string str in words) {
            wset.Add(str);
        }
        foreach(string str in words) {
            max = Math.Max(max, dfs(wset, map, str));
        }
        return max;
    }
    private int dfs(HashSet<string> words, Dictionary<string, int> dic, string crrWord) {
        if(dic.ContainsKey(crrWord)) {
            return dic[crrWord];
        }
        StringBuilder sb = new StringBuilder();
        sb.Append(crrWord);
        int max = 1;
        for(int i = 0; i < crrWord.Length; i++) {
            sb.Remove(i, 1);
            string str = sb.ToString();
            if(words.Contains(str)) {
                max = Math.Max(max, dfs(words, dic, str) + 1);
            }
            sb.Insert(i, crrWord[i]);
        }
        dic.Add(crrWord, max);
        return max;
    }
}