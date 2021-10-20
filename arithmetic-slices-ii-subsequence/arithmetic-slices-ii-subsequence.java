class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        HashMap<Integer, Integer>[] map = new HashMap[nums.length];
        long res = 0;
        for(int i = 0; i < nums.length; i++) {
            map[i] = new HashMap<>();
            for(int j = 0; j < i; j++) {
                long d = (long)nums[i] - (long)nums[j];
                if(d < Integer.MIN_VALUE || d > Integer.MAX_VALUE) continue;
                int diff = (int)d;
                int sum = map[j].getOrDefault(diff, 0);
                int crr = map[i].getOrDefault(diff, 0);
                map[i].put(diff, sum + crr + 1);
                res += sum;
            }
        }
        return (int)res;
    }
}