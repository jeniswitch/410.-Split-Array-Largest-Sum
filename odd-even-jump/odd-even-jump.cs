public class Solution {
    public int OddEvenJumps(int[] arr) {
        bool[] high = new bool[arr.Length];
        bool[] low = new bool[arr.Length];
        int lastIdx = arr.Length - 1;
        high[lastIdx] = true;
        low[lastIdx] = true;
        SortedList<int, int> dic = new SortedList<int, int>();
        dic.Add(arr[lastIdx], lastIdx);
        int res = 1;
        for(int i = arr.Length - 2; i >= 0; i--) {
            int higherIdx = i;
            int lowerIdx = i;
            if(dic.ContainsKey(arr[i])) {
                higherIdx = dic[arr[i]];
                lowerIdx = dic[arr[i]];
                dic[arr[i]] = i;
            }
            else {
                dic.Add(arr[i], i);
                int index = dic.IndexOfKey(arr[i]);
                lowerIdx = index == 0? i : dic.Values[index - 1];
                higherIdx = index == dic.Count - 1? i : dic.Values[index + 1];
            }
            if(higherIdx > i && low[higherIdx]) {
                high[i] = true;
                res++;
            }
            if(lowerIdx > i && high[lowerIdx]) {
                low[i] = true;
            }
        }
        return res;
    }

}