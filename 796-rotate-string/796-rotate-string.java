class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length()) {
            return false;
        }
        String t = s + s;
        return t.contains(goal);
    }
}