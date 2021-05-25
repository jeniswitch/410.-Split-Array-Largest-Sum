public class Solution {
    public int NumSubarraysWithSum(int[] nums, int goal) {
        int[] sum = new int[nums.Length + 1];
        for(int i = 0; i < nums.Length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
        var dic = new Dictionary<int, int>();
        int count = 0;
        foreach(int s in sum) {
            if(dic.ContainsKey(s)) {
                count += dic[s];
            }
            if(dic.ContainsKey(s + goal)) {
                dic[s + goal]++;
            }
            else {
                dic[s + goal] = 1;
            }
        }
        return count;
    }
}