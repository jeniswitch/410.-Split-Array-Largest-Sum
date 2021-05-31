public class Solution {
    public int NumSubarraysWithSum(int[] nums, int goal) {
        int count = 0;
        var dic = new Dictionary<int, int>();
        int sum = 0;
        foreach(int num in nums) {
            sum += num;
            if(dic.ContainsKey(sum - goal)) {
                count += dic[sum - goal];
            }
            if(sum == goal) {
                count++;
            }
            if(dic.ContainsKey(sum)) {
                dic[sum]++;
            }
            else {
                dic[sum] = 1;
            }
        }
        return count;
    }
}