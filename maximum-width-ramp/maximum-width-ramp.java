class Solution {
    public int maxWidthRamp(int[] nums) {
        var decList = new ArrayList<Integer>();
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i == 0 || nums[i] < nums[decList.get(decList.size() - 1)]) {
                decList.add(i);
            }
            else {
                int l = 0, r = decList.size() - 1;
                while(l < r) {
                    int mid = l + r >> 1;
                    if(nums[decList.get(mid)] > nums[i]) {
                        l = mid + 1;
                    }
                    else {
                        r = mid;
                    }
                }
                res = Math.max(res, i - decList.get(l));
            }
        }
        return res;
    }
}