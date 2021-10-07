class Solution {
    public String reverseWords(String s) {
        String[] arr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(String a : arr) {
            sb.append(reverse(a) + " ");
        }
        String str = sb.toString();
        return str.trim();
    }
    private String reverse(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = s.length() - 1; i >= 0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}