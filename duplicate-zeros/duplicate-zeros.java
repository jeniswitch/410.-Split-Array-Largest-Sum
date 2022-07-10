class Solution {
    public void duplicateZeros(int[] arr) {
        int[] temp = new int[arr.length];
        int i = 0, j = 0;
        while(j < arr.length) {
            temp[j++] = arr[i];
            if(arr[i++] == 0 && j < arr.length) {
                temp[j++] = 0;
            }
        }
        i = 0;
        while(i < arr.length) {
            arr[i] = temp[i];
            i++;
        }
    }
}