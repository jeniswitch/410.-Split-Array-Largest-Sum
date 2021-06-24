class Solution {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        int i = 0, j = 0;
        Arrays.sort(slots1, (a, b) -> a[0] - b[0]);
        Arrays.sort(slots2, (a, b) -> a[0] - b[0]);
        while(i < slots1.length && j < slots2.length) {
            int[] slot1 = slots1[i];
            int[] slot2 = slots2[j];
            int start = Math.max(slot1[0], slot2[0]);
            int end = Math.min(slot1[1], slot2[1]);
            if(end - start >= duration) {
                return Arrays.asList(start, start + duration);
            }
            if(slot1[1] == end) {
                i++;
            }
            if(slot2[1] == end) {
                j++;
            }
        }
        return new ArrayList<>();
    }
}