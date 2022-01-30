class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int n = s.length();
        long sum = 0;
        long p = 1;
        for(int j = n - k; j < n; j++) {
            sum += (s.charAt(j) - 'a' + 1) * p;
            if(j < n - 1) {
                p = p * power % modulo;
            }
        }
        
        int idx = -1;
        if(sum % modulo == hashValue) idx = n - k;
        for(int i = n - k - 1; i >= 0; i--) {
            //System.out.println(s.charAt(i + k) - 'a' + 1 + " * " + p);
            long lastItem = (s.charAt(i + k) - 'a' + 1) * p % modulo;
            //System.out.println("sum " + sum + " lastItem " + lastItem);
            long temp = (sum - lastItem);
            while(temp < 0) {
                temp += modulo;
            }
            //System.out.println("temp " + temp);
            sum = (temp % modulo * power) % modulo + (s.charAt(i) - 'a' + 1);
            //System.out.println("String: " + s.substring(i, i + k) + " sum: " + sum);
            if(sum % modulo == hashValue) idx = i;
        }
        return s.substring(idx, idx + k);
    }
}