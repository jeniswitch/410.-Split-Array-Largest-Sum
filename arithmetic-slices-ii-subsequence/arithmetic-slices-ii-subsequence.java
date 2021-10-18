class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        long res = 0;
        Map<Integer, Integer>[] count = new Map[n];
        for(int i = 0; i < n; i++) {
            count[i] = new HashMap<>(i);
            for(int j = 0; j < i; j++) {
                long d = (long)nums[i] - (long)nums[j];
                if(d < Integer.MIN_VALUE || d > Integer.MAX_VALUE) {
                    continue;
                }
                int dd = (int)d;
                int sum = count[j].getOrDefault(dd, 0);
                int origin = count[i].getOrDefault(dd, 0);
                count[i].put(dd, origin + sum + 1);
                res += sum;
            }
        }
        return (int) res;
    }
}