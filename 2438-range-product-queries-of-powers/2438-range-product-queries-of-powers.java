class Solution {
    public int[] productQueries(int n, int[][] queries) {
        String str = Integer.toBinaryString(n);
        int pow = 1;
        List<Integer> lst = new ArrayList<>();
        for(int i = str.length() - 1; i >= 0; i--) {
            if(str.charAt(i) == '1') {
                lst.add(pow);
            }
            pow *= 2;
        }
        long mod = (long)1e9 + 7;
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            long prod = 1;
            for(int j = queries[i][0]; j <= queries[i][1]; j++) {
                prod = (prod * lst.get(j)) % mod;
            }
            res[i] = (int)prod;
        }
        return res;
        
    }
}