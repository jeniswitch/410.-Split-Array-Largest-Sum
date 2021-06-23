/*
    firstList = [[0,2],[5,10],[13,23],[24,25]], 
                                        p1
    secondList = [[1,5],[8,12],[15,24],[25,26]]
                                         p2
    1. a1 <= b1 a2 in [b1, b2], [1,2] p1++ [8,10] p1++ [15, 23] p1++[25,25] p1++
    2. a1 in [b1,b2] [5,5] p2++ [24,24] p2++ 
    3. a1 > b2 p2++
*/
class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> res = new ArrayList<>();
        int p1 = 0, p2 = 0;
        while(p1 < firstList.length && p2 < secondList.length) {
            int[] a = firstList[p1];
            int[] b = secondList[p2];
            if(a[0] <= b[0] && a[1] >= b[0]) {
                res.add(new int[]{b[0], Math.min(b[1], a[1])});
                if(a[1] < b[1]) {
                    p1++;
                }
                else {
                    p2++;
                }
            }
            else if(a[0] >= b[0] && a[0] <= b[1]) {
                res.add(new int[]{a[0], Math.min(a[1], b[1])});
                if(a[1] < b[1]) {
                    p1++;
                }
                else {
                    p2++;
                }
            }
            else if(a[0] > b[1]) {
                p2++;
            }
            else {
                p1++;
            }
        }
        int[][] intArray = new int[res.size()][];
        //intArray = res.toArray(intArray);

        return res.toArray(intArray);
    }
}