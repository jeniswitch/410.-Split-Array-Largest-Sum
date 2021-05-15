public class Solution {
    public bool CanReach(int[] arr, int start) {
        Queue<int> q = new Queue<int>();
        q.Enqueue(start);
        while(q.Count > 0) {
            int index = q.Dequeue();
            if(arr[index] == 0) {
                return true;
            }
            if(arr[index] < 0) {
                continue;
            }
            int right = index + arr[index];
            int left = index - arr[index];
            if(right < arr.Length) {
                q.Enqueue(right);
            }
            if(left >= 0) {
                q.Enqueue(left);
            }
            arr[index] = -arr[index];
        }
        return false;
    }
}