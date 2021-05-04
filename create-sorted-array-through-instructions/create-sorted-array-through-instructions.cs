public class Solution {
    public class BITree {
        int[] arr;
        public BITree(int size) {
            arr = new int[size];
        }
        public void Update(int index) {
            index++;
            while(index < arr.Length) {
                arr[index]++;
                index += index & (-index);
            }
        }
        public int Get(int index) {
            index++;
            int sum = 0;
            while(index > 0) {
                sum += arr[index];
                index -= index & (-index);
            }
            return sum;
        }
    }
    public int CreateSortedArray(int[] instructions) {
        BITree tree = new BITree(100002);
        long cost = 0;
        long mod = 1000000007;
        for(int i = 0; i < instructions.Length; i++) {
            int left = tree.Get(instructions[i] - 1);
            int right = i - tree.Get(instructions[i]);
            cost += Math.Min(left, right);
            tree.Update(instructions[i]);
        }
        return (int)(cost % mod);
    }
}