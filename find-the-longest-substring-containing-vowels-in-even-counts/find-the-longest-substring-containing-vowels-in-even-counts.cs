public class Solution {
    public int FindTheLongestSubstring(string s) {
        char[] vowels = new char[]{'a', 'e', 'i', 'o', 'u'};
        var bitmask = new Dictionary<char, int>();
        for(int i = 0; i < 5; i++){
            bitmask.Add(vowels[i], (1 << i));
        }
        int state = 0;
        var stateMap = new Dictionary<int, int>();
        stateMap.Add(0, -1);
        int max = 0;
        for(int i = 0; i < s.Length; i++) {
            char c = s[i];
            if(bitmask.ContainsKey(c)) {
                state ^= bitmask[c];
                if(!stateMap.ContainsKey(state)) {
                    stateMap.Add(state, i);
                }
            }
            max = Math.Max(max, i - stateMap[state]);
        }
        return max;
    }
}