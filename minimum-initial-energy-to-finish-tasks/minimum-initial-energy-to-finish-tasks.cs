public class Solution {
    public int MinimumEffort(int[][] tasks) {
        int energy = 0;
        int res = 0;
        int[][] clone = tasks.Select(k => k.ToArray()).ToArray();
        Array.Sort(clone, (x, y) => {return (y[1] - y[0]) - (x[1] - x[0]);});
        for(int i = 0; i < clone.Length; i++) {
            if(energy < clone[i][1]) {
                int borrow = clone[i][1] - energy;
                energy += borrow;
                res += borrow;
            }
            energy -= clone[i][0];
        }
        return res;
    }
}