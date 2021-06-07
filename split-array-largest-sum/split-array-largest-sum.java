class Solution {
    public int splitArray(int[] nums, int m) {
        int l = nums[0], r = 0;
        for(int num : nums) {
            l = Math.max(num, l);
            r += num;
        }
        System.out.println(l + " " + r);
        while(l < r) {
            int mid = l + r >> 1;
            System.out.println(l + " " + r);
            if(Check(nums, m, mid)) {
                System.out.println("true");
                r = mid;
            }
            else {
                System.out.println("false");
                l = mid + 1;
            }
        }
        return l;
    }
    private boolean Check(int[] nums, int m, int maxSum) {
        int localSum = 0;
        int count = 1;
        for(int num : nums) {
            localSum += num;
            if(localSum > maxSum) {
                count++;
                localSum = num;
            }
        }
        return count <= m;
    }
}