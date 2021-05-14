public class Solution {
    public int MaxSatisfaction(int[] satisfaction) {
        int sum = 0;
        int res = 0;
        Array.Sort(satisfaction);
        for(int i = satisfaction.Length - 1; i >= 0 && satisfaction[i] > -sum; i--) {
            sum += satisfaction[i];
            res += sum;
        }
        return res;
    }
}