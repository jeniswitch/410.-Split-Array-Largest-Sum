class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        int[][] etasks = new int[n][3];
        for(int i = 0; i < n; i++) {
            etasks[i][0] = i;
            etasks[i][1] = tasks[i][0];
            etasks[i][2] = tasks[i][1];
        }
        
        int[] res = new int[n];
        Arrays.sort(etasks, (a, b) -> a[1] - b[1]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2] == 0 ? a[0] - b[0] : a[2] - b[2]);
        int t = 0, i = 0, index = 0;
        while(index < n) {
            while(i < n && etasks[i][1] <= t) {
                pq.offer(etasks[i++]);
            }
            if(pq.isEmpty()) {
                t = etasks[i][1];
                continue;
            }
            int[] task = pq.poll();
            res[index++] = task[0];
            t += task[2];
        }
        return res;
    }
}