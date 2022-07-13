class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] letters = new int[26];
        for(char c : s.toCharArray()) {
            letters[c - 'a']++;
        }
        int odd = 0;
        int even = 0;
        for(int i = 0; i < 26; i++) {
            if(letters[i] > 0) {
                if(letters[i] % 2 > 0) {
                    odd++;
                }
                else {
                    even++;
                }
            }
            if(even > 0 && odd > 1) {
                return false;
            }
        }
        return  odd == 0 || even >= 0 && odd == 1;
    }
}