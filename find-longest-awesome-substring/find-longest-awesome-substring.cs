public class Solution {
    public int LongestAwesome(string s) {
        int[] bitmask = new int[1024];
        Array.Fill(bitmask, s.Length);
        bitmask[0] = -1;
        int state = 0, max = 0;
        for(int i = 0; i < s.Length; i++) {
            state ^= 1 << (s[i] - '0');
            max = Math.Max(max, i - bitmask[state]);
            //flip one bit
            for(int j = 0; j < 10; j++) {
                max = Math.Max(max, i - bitmask[state ^ (1 << j)]);
            }
            bitmask[state] = Math.Min(bitmask[state], i);
        }
        return max;
    }
}