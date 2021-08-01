class Solution {
    public long numberOfWeeks(int[] milestones) {
        long sum = 0, max = 0;
        for(int i = 0; i < milestones.length; i++) {
            sum += milestones[i];
            max = Math.max(max, milestones[i]);
        }
        return Math.min(sum, 2 * (sum - max) + 1);
    }
}