class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        double[] p = new double[n];
        Map<Integer, List<int[]>> map = new HashMap<>();
        for(int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            map.putIfAbsent(a, new ArrayList<int[]>());
            map.putIfAbsent(b, new ArrayList<int[]>());
            map.get(a).add(new int[]{b, i});
            map.get(b).add(new int[]{a, i});
        }
        p[start] = 1d;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.comparingDouble(i -> -p[i]));
        pq.offer(start);
        while(!pq.isEmpty()) {
            int crr = pq.poll();
            if(crr == end) {
                return p[end];
            }
            for(int[] lst : map.getOrDefault(crr, Collections.emptyList())) {
                int nb = lst[0];
                int idx = lst[1];
                double newP = p[crr] * succProb[idx];
                if(newP > p[nb]) {
                    p[nb] = newP;
                    pq.offer(nb);
                }
            }
        }
        return 0d;
    }
}