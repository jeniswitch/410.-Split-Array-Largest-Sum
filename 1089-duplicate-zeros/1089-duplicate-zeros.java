class Solution {
    public void duplicateZeros(int[] arr) {
        int count0 = 0;
        for(int a : arr) {
            if(a == 0) {
                count0++;
            }
        }
        int len = arr.length;
        int newLen = len + count0;
        for(int i = len - 1, j = newLen - 1; i < j; i--, j--) {
            if(arr[i] == 0) {
                if(j < len) {
                    arr[j] = 0;
                }
                j--;
                if(j < len) {
                    arr[j] = 0;
                }
            }
            else if(j < len){
                arr[j] = arr[i];
            }
        }
    }
}