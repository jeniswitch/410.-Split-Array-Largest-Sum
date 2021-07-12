class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] stack = new int[n];
        int t = -1;
        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            while(t >= 0 && temperatures[stack[t]] < temperatures[i]) {
                ans[stack[t]] = i - stack[t];
                t--;
            }
            stack[++t] = i;
        }
        return ans;
    }
}