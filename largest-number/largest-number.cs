public class Solution {
    public string LargestNumber(int[] nums) {
        Console.WriteLine(("330").CompareTo("303"));
        List<string> strs = nums.Select(x => x.ToString()).ToList();
        strs.Sort((x, y) => (y + x).CompareTo(x + y));
        return strs[0] == "0"? "0" : String.Join("", strs);
    }
}