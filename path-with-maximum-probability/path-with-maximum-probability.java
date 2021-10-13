class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] p = new double[n];
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            int a = edges[i][0]; int b = edges[i][1];
            map.putIfAbsent(a, new ArrayList<>());
            map.putIfAbsent(b, new ArrayList<>());
            map.get(a).add(new int[]{b, i});
            map.get(b).add(new int[]{a, i});
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        p[start] = 1;
        pq.offer(start);
        while(!pq.isEmpty()) {
            int crr = pq.poll();
            for(int[] rec : map.getOrDefault(crr, Collections.emptyList())) {
                int nb = rec[0];
                int idx = rec[1];
                if(p[nb] < p[crr] * succProb[idx]) {
                    p[nb] = p[crr] * succProb[idx];
                    pq.offer(nb);
                }
            }
        }
        return p[end];
    }
}