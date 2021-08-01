class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        TreeMap<Integer, Integer> tm = new TreeMap<>();
        int i = 0, n = intervals.length;
        int[] Q = queries.clone();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        Arrays.sort(Q);
        
        for(int q : Q) {
            while(i < n && intervals[i][0] <= q) {
                int l = intervals[i][0];
                int r = intervals[i++][1];
                tm.put(r - l + 1, r);
            }
            while(!tm.isEmpty() && tm.firstEntry().getValue() < q) {
                tm.pollFirstEntry();
            }
            hm.put(q, tm.isEmpty() ? -1 : tm.firstKey());
        }
        int[] res = new int[queries.length];
        for(i = 0; i < res.length; i++) {
            res[i] = hm.get(queries[i]);
        }
        return res;
    }
}