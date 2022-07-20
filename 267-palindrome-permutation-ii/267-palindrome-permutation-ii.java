class Solution {
    public List<String> generatePalindromes(String s) {
        int[] count = new int[26];
        String uniq = "";
        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        List<String> res = new ArrayList<>();
        String center = "";     
        int odd = 0;
        for(int i = 0; i < 26; i++) {
            int ct = count[i];
            if(ct == 0) continue;
                  
            if(ct % 2 > 0) {
                odd++;
                if(odd > 1) return res;
                center = String.valueOf((char)('a' + i));
                count[i]--;
            }
        }
        helper(count, center, res, s.length());
        return res;
    }
    private void helper(int[] count, String center, List<String> res, int len) {
        if(center.length() == len) {
            res.add(center);
            return;
        }
        for(int i = 0; i < count.length; i++) {
            if(count[i] > 0) {
                char c = (char)('a' + i);
                count[i] -= 2;
                helper(count, c + center + c, res, len);
                count[i] += 2;
            }
        }
    }
}