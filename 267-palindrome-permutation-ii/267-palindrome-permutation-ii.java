class Solution {
    public List<String> generatePalindromes(String s) {
        int[] count = new int[26];
        String uniq = "";
        for(char c : s.toCharArray()) {
            count[c - 'a']++;
        }
        System.out.println(uniq);
        List<String> res = new ArrayList<>();
        String center = "";
        Set<Character> set = new HashSet<>();
        int odd = 0, even = 0;
        for(int i = 0; i < 26; i++) {
            int ct = count[i];
            if(ct == 0) continue;
            char c = (char)('a' + i);            
            
            if(ct % 2 > 0) {
                odd++;
                if(odd > 1) {
                    return res;
                }
                center = String.valueOf(c);
                set.add(c);
            }
            else {
                if(!set.contains(c)) {
                    uniq += String.valueOf(c);
                    set.add(c);
                }
               even++; 
            }
            
        }
        //if(odd > 1) return res;
        if(odd == 1 && count[center.charAt(0) - 'a'] > 1) {
            uniq += center;
            count[center.charAt(0) - 'a']--;
        }
        System.out.println(uniq);
        helper(uniq, count, center, center, res, s.length());
        return res;
    }
    private void helper(String uniq, int[] count, String center, String str, List<String> res, int len) {
        if(str.length() == len) {
            res.add(str);
            return;
        }
        for(char c : uniq.toCharArray()) {
            if(count[c - 'a'] > 0) {
                str = c + str + c;
                count[c - 'a'] -= 2;
                helper(uniq, count, center, str, res, len);
                if(str.length() > 2) {
                    str = str.substring(1, 2) + str.substring(2, str.length() - 1);
                }
                else if(str.length() == 2) {
                    str = center;
                }
                count[c - 'a'] += 2;
            }
        }
    }
}