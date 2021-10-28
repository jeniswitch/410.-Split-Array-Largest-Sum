class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] len = new int[nums.length];
        int[] count = new int[nums.length];
        int max = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            len[i] = 1;
            count[i] = 1;
            for(int j = 0; j < i; j++) {
                if(nums[j] < nums[i]) {
                    if(len[j] + 1 == len[i]) {
                        count[i] += count[j];
                    }
                    else if(len[j] + 1 > len[i]) {
                        len[i] = len[j] + 1;
                        count[i] = count[j];
                    }
                }
            }
            if(max == len[i]) res += count[i];
            else if(max < len[i]) {
                res = count[i];
                max = len[i];
            } 
        }
        return res;
    }
}