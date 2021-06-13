class Solution {
    public int kthSmallest(int[][] mat, int k) {
        var pq = new PriorityQueue<Integer>((a, b) -> b - a);
        pq.offer(0);
        int col = Math.min(mat[0].length, k);
        for(int[] row : mat) {
            var nextPq = new PriorityQueue<Integer>((a, b) -> b - a);
            while(!pq.isEmpty()) {
                int crr = pq.poll();
                for(int i = 0; i < col; i++) {
                    nextPq.offer(crr + row[i]);
                    if(nextPq.size() > k) {
                        nextPq.poll();
                    }
                }
            }
            pq = nextPq;
        }
        return pq.poll();
    }
}