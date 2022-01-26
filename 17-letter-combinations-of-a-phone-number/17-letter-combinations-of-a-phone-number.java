class Solution {
    private List<String> lst;
    public List<String> letterCombinations(String digits) {
        HashMap<Character, char[]> temp = new HashMap<>();
        lst = new ArrayList<>();
        if(digits.length() == 0) return lst;
        char crr = 'a';
        for(int i = 2; i < 10; i++) {
            if(i != 7 && i != 9) {
                temp.put((char)('0' + i), new char[]{(char)(crr++), (char)(crr++), (char)(crr++)});
            }
            else {
                temp.put((char)('0' + i), new char[]{(char)(crr++), (char)(crr++), (char)(crr++), (char)(crr++)});
            }
        }
        HashMap<Character, char[]> map = new HashMap<>();
        for(char c : digits.toCharArray()) {
            map.put(c, temp.get(c));
        }
        dfs(map, 0, new StringBuilder(), digits);
        return lst;
    }
    private void dfs(HashMap<Character, char[]> map, int i, StringBuilder sb, String str) {
        if(i == str.length()) {
            lst.add(sb.toString());
            return;
        }
        char crr = str.charAt(i);
        char[] arr = map.get(crr);
        for(int j = 0; j < arr.length; j++) {
            dfs(map, i + 1, sb.append(arr[j]), str);
            sb.setLength(sb.length() - 1);
        }
    }
}