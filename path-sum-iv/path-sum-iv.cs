public class Solution {
    private Dictionary<int, int> dic;
    private int count = 0;
    public int PathSum(int[] nums) {
        dic = new Dictionary<int, int>();
        foreach(int num in nums) {
            dic.Add(num / 10, num % 10);
        }
        dfs(nums[0] / 10, 0);
        return count;
    }
    private void dfs(int DP, int crrSum) {
        if(!dic.ContainsKey(DP)) {
            return;
        }
        int depth = DP / 10;
        int pos = DP % 10;
        crrSum += dic[DP];
       
        int leftChild = (depth + 1) * 10 + 2 * pos - 1;
        if(!dic.ContainsKey(leftChild) && !dic.ContainsKey(leftChild + 1)) {
            count += crrSum;
        }
        else {
            dfs(leftChild, crrSum);
            dfs(leftChild + 1, crrSum);
        }
    }
}