class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0, max = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, nums[i]);
        }
        if(sum % k != 0) {
            return false;
        }
        return dfs(nums, k, sum / k, 0, 0, new boolean[nums.length]);
    }
    private boolean dfs(int[] nums, int k, int targetSum, int crrSum, int nextIndex, boolean[] visited) {
        if(k == 0) {
            return true;
        }
        if(targetSum == crrSum) {
            return dfs(nums, k - 1, targetSum, 0, 0, visited);
        }
        for(int i = nextIndex; i < nums.length; i++) {
            if(!visited[i] && crrSum + nums[i] <= targetSum) {
                visited[i] = true;
                if(dfs(nums, k, targetSum, crrSum + nums[i], i + 1, visited)) {
                    return true;
                }
                visited[i] = false;
            }            
        }
        return false;
    }
}