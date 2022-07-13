class Solution {
    public boolean canPermutePalindrome(String s) {
        int[] letters = new int[26];
        for(char c : s.toCharArray()) {
            letters[c - 'a']++;
        }
        boolean findodd = false;
        for(int i = 0; i < 26; i++) {
            if(letters[i] % 2 > 0) {
                if(findodd) {
                    return false;
                }
                findodd = true;
            }
            
        }
        return true;
    }
}