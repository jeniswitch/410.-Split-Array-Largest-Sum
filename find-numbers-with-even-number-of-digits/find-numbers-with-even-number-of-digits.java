class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for(int n : nums) {
            if(EvenNumOfDigits(n)) {
                count++;
            }
        }
        return count;
    }
    private boolean EvenNumOfDigits(int num) {
        num = num / 10;
        int count = 1;
        while(num > 0) {
            num = num / 10;
            count++;
        }
        return count % 2 == 0;
    }
}