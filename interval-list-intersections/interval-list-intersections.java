class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int i = 0, j = 0;
        while(i < firstList.length && j < secondList.length) {
            int[] a = firstList[i];
            int[] b = secondList[j];
            int start = Math.max(a[0], b[0]);
            int end = Math.min(a[1], b[1]);
            if(end >= start) {
                res.add(new int[]{start, end});
            }
            if(a[1] == end) i++;
            if(b[1] == end) j++;
            
        }
        return res.toArray(new int[res.size()][]);
    }
}