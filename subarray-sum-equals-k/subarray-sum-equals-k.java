/*
        1   1   1       2
        1   2   3
        
        0. 1
        3, 1
        4, 1
        
        1   2      3   k =3
        1   3      6
        
        4, 1
        6, 1
        
*/
class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if(sum == k) count++;
             if(map.containsKey(sum)) {
                count += map.get(sum);
            }
            map.put(k + sum, map.getOrDefault(k + sum, 0) + 1);
        }
        return count;
    }
}