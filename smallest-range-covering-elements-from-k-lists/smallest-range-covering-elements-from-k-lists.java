/*
1. smallest range
2. includes at least 1 number from list
*/
class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        var pq = new PriorityQueue<int[]>((a, b) -> nums.get(a[0]).get(a[1]) - nums.get(b[0]).get(b[1]));
        int max = nums.get(0).get(0);
        for(int i = 0; i < nums.size(); i++) {
            pq.offer(new int[]{i, 0});
            max = Math.max(max, nums.get(i).get(0));
        }
        int start = 0, end = Integer.MAX_VALUE;
        while(pq.size() == nums.size()) {
            int[] index = pq.poll();
            int row = index[0], col = index[1];
            if(max - nums.get(row).get(col) < end - start) {
                start = nums.get(row).get(col);
                end = max;
            }
            if(col + 1 < nums.get(row).size()) {
                pq.offer(new int[]{row, col + 1});
                max = Math.max(max, nums.get(row).get(col + 1));
            }
        }
        return new int[] {start, end};
    }
}