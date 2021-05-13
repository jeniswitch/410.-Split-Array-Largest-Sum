public class Solution {
    public int MaximumGap(int[] nums) {
        if(nums.Length < 2) {
            return 0;
        }
        int min = Int32.MaxValue;
        int max = Int32.MinValue;
        for(int i = 0; i < nums.Length; i++) {
            min = Math.Min(min, nums[i]);
            max = Math.Max(max, nums[i]);
        }
        Console.WriteLine(min + " " + max);
        int[] bucketMin = new int[nums.Length - 1];
        int[] bucketMax = new int[nums.Length - 1];
        Array.Fill(bucketMin, Int32.MaxValue);
        Array.Fill(bucketMax, Int32.MinValue);
        int bucketSize = (int)Math.Ceiling((double)(max - min) / (nums.Length - 1));
        
        //update min and max in each bucket
        foreach(int num in nums) {
            if(num > min && num < max) {
                int idx = (num - min) / bucketSize;
                bucketMin[idx] = Math.Min(num, bucketMin[idx]);
                bucketMax[idx] = Math.Max(num, bucketMax[idx]);
            } 
        }
        
        //check each bucket, find max gap
        int preMax = min;
        int maxGap = Int32.MinValue;
        for(int i = 0; i < nums.Length - 1; i++) {
            if(bucketMin[i] != Int32.MaxValue && bucketMax[i] != Int32.MinValue) {
                //Console.WriteLine(maxGap + " " +  bucketMin[i] + " " + preMax);
                maxGap = Math.Max(maxGap, bucketMin[i] - preMax);
                preMax = bucketMax[i];
            }
        }
        maxGap = Math.Max(maxGap, max - preMax);
        return maxGap;
    }
}