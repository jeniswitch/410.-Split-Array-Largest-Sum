class Solution {
    public int longestBeautifulSubstring(String word) {
        HashSet<Character> set = new HashSet<Character>();
        int max = 0;
        for(int i = 0; i < word.length(); i++) {
            int j = i + 1;
            set.add(word.charAt(i));
            while(j < word.length() && word.charAt(j) >= word.charAt(j - 1)) {
                set.add(word.charAt(j));
                j++;
            }
            if(set.size() == 5) {
                max = Math.max(max, j - i);
            }
            set = new HashSet<>();
            i = j - 1;
        }
        return max;
    }
}