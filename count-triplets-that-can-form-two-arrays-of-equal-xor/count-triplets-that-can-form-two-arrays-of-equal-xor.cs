public class Solution {
    public int CountTriplets(int[] arr) {
        int count = 0;
        int[] prefix = new int[arr.Length + 1];
        for(int i = 0; i < arr.Length; i++) {
            prefix[i + 1] = prefix[i] ^ arr[i];
        }
        for(int i = 0; i < arr.Length; i++) {
            for(int j = i + 1; j < arr.Length + 1; j++) {
                if(prefix[i] == prefix[j]) {
                    count += j - i - 1;
                }
            }
        }
        return count;
    }
}