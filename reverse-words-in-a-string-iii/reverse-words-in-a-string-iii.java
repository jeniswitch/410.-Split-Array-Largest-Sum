class Solution {
    public String reverseWords(String s) {
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] != ' ') {
                int j = i + 1;
                while(j < arr.length && arr[j] != ' ') {
                    j++;
                }
                reverse(arr, i, j - 1);
                i = j;
            }
        }
        return new String(arr);
    }
    private void reverse(char[] s, int i, int j) {
        while(i < j) {
            char temp = s[j];
            s[j--] = s[i];
            s[i++] = temp;
        }
    }
}