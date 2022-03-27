class Solution {
    private String[] LessThan20 = {"", "One", "Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten",                                               "Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen","Eighteen","Nineteen"};
    private String[] Tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private String[] More = {"", "Thousand", "Million", "Billion"};
    public String numberToWords(int num) {
        if(num == 0) return "Zero";
        String word = "";
        int i = 0;
        while(num > 0) {
            if(num % 1000 != 0) {
                word = helper(num % 1000) + More[i] +" " + word;
            }
            num = num / 1000;
            i++;
        }
        return word.trim();
    }
    private String helper(int num) {
        if(num == 0) {
            return "";
        }
        if(num < 20) {
            return LessThan20[num] + " ";
        }
        else if(num < 100) {
            return Tens[num / 10] + " " +  helper(num % 10);
        }
        else {
            return LessThan20[num / 100] + " Hundred " + helper(num % 100);
        }
    }
}