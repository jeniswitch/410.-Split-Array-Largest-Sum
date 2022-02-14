class Solution {
    public long minimumRemoval(int[] beans) {
        long sum = 0;
        for(int i = 0; i < beans.length; i++) {
            sum += beans[i];
        }
        Arrays.sort(beans);
        long max = 0;
        for(int i = 0; i < beans.length; i++) {
            max = Math.max(max, (long)(beans.length - i) * (long)beans[i]);
        }
        return sum - max;
    }
}