class Solution {
    /*
    [1],
    [1,1],
    [1,2,1],
    [1,3,3,1],
    [1,4,6,4,1]]
    */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> fst = new ArrayList<>();
        fst.add(1);
        res.add(fst);
        for(int i = 1; i < numRows; i++) {
            List<Integer> lst = new ArrayList<>();
            for(int j = 0; j < i + 1; j++) {
                if(j == 0 || j == i) lst.add(1);
                else {
                    List<Integer> last = res.get(i - 1);
                    lst.add(last.get(j - 1) + last.get(j));
                }
            }
            res.add(lst);
        }
        return res;
    }
}