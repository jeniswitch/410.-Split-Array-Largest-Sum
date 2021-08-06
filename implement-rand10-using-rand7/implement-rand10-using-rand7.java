/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        int row = 0, col = 0, idx = 0;
        do {
            row = rand7();
            col = rand7();
            idx = (row - 1) * 7 + col;
        }while(idx > 40);
        return (idx - 1) % 10  + 1;
    }
}