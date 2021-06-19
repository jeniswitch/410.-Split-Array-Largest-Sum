class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> lst = new ArrayList<>();
        lst.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++) {
            int[] lastIv = lst.get(lst.size() - 1);
            if(intervals[i][0] <= lastIv[1]) {
                lastIv[1] = Math.max(lastIv[1], intervals[i][1]);
            }
            else {
                lst.add(intervals[i]);
            }
        }
        return lst.toArray(new int[lst.size()][]);
    }
}