class Solution {
    public List<String> generatePalindromes(String s) {
        int[] count = new int[26];
        List<String> res = new ArrayList<>();
        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        boolean foundOdd = false;
        String center = "";
        for(int i = 0; i < count.length; i++) {
            if(count[i] > 0) {
                if(count[i] % 2 > 0) {
                    if(foundOdd) return res;
                    foundOdd = true;
                    center = String.valueOf((char)('a' + i));
                    count[i]--;
                }
            }
        }
        helper(res, center, s.length(), count);
        return res;
    }
    private void helper(List<String> res, String str, int len, int[] count) {
        if(str.length() == len) {
            res.add(str);
            return;
        }
        for(int i = 0; i < count.length; i++) {
            if(count[i] > 0 && count[i] % 2 == 0) {
                count[i] -= 2;
                char c = (char)('a' + i);
                helper(res, c + str + c, len, count);
                count[i] += 2;
            }
        }
    }
}