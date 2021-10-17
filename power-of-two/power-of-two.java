class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n == 0) return false;
        long l = (long)n;
        return (l & (-l)) == l;
    }
}