class Solution {
    public List<List<Integer>> findRLEArray(int[][] encoded1, int[][] encoded2) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int i = 0, j = 0;
        while(i < encoded1.length && j < encoded2.length) {
            int[] a = encoded1[i];
            int[] b = encoded2[j];
            int product = a[0] * b[0];
            int freq = Math.min(a[1], b[1]);
            if(res.size() == 0 || res.get(res.size() - 1).get(0) != product) {
                res.add(Arrays.asList(product, freq));
            }
            else {
                res.get(res.size() - 1).set(1, res.get(res.size() - 1).get(1) + freq);
            }
            a[1] -= freq;
            b[1] -= freq;
            if(a[1] == 0) {
                i++;
            }
            if(b[1] == 0) {
                j++;
            }
        }
        return res;
    }
}