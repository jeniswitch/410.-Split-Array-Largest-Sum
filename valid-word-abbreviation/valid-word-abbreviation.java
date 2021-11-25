class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while(i < word.length() && j < abbr.length()) {
            if(abbr.charAt(j) == '0') return false;
            else if(abbr.charAt(j) > '0' && abbr.charAt(j) <= '9') {
                int num = 0;
                while(j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                    num = num * 10 + abbr.charAt(j++) - '0';
                }
                i += num;
            }
            else if(word.charAt(i) != abbr.charAt(j)) {
                return false;
            }
            else {
                i++;
                j++;
            }
        }
        return i == word.length() && j == abbr.length();
    }
}