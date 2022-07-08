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
        String strNum = String.valueOf(num);
        return strNum.length() % 2 == 0;
    }
}